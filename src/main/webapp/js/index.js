const {of, map, switchMap, debounceTime, fromEvent, from, ajax: {ajax}} = rxjs;
const {getJSON: ajaxJson} = ajax;
const documentReady$ = from(new Promise((resolve, reject) => $(document).ready(() => resolve())));
const MIN_LENGTH  = 3;


removeErrors = () => (source) => source.pipe(rxjs.tap(() => {
    $('.error-section').empty();
    $('input').removeClass('with--error');
}));

const addError = (error) => {
    $('.error-section').append(`<p>${error}</p>`);
    $('input').addClass('with--error');
}

const onError = (error) => (source) =>
    source.pipe(
        rxjs.tap(() => console.error(error)),
        rxjs.map(() => addError(error)),
        rxjs.mergeMap(() => rxjs.timer(2000)),
        rxjs.filter(() => false)
    )

const pipeUnless = (predicate, operator) => {
    return (source) => source.pipe(rxjs.mergeMap(value => predicate(value) ? of(value) : of(value).pipe(operator)))
}

const lengthValidator = () => {
    const getLength = (event) => event.target.value.length;
    return (source) => source.pipe(pipeUnless(event => getLength(event) > 3 || getLength(event) === 0, onError('A cidade precisa ter ao menos 3 caractéres')))
}

const numberValidator = () => {
    const hasNoNumbers = (event) => /^([^0-9]*)$/.test(event.target.value);
    return source => source.pipe(pipeUnless(event => hasNoNumbers(event), onError('A cidade não pode ter números')))
}

const getCityDetails = (city) => ajaxJson(`http://localhost:8080/api/endereco?cidade=${city}`);
const doRenderMethod = (show) => show ? 'show' : 'hide';
const userCard = (info) => ` <div class="card"> <span>${info.id}</span> <span>${info.nome}</span> </div>`
const hasResults = (res) => !!res.clientes.length;

from(documentReady$)
    .pipe(
        map(() => $('#search-input').get(0)),
        switchMap(input => fromEvent(input, 'keyup')),
        debounceTime(400),
        removeErrors(),
        lengthValidator(),
        numberValidator(),
        rxjs.mergeMap(event => getCityDetails(event.target.value))
    ).subscribe(res => {
        $('div.card').remove();
        const isValid = hasResults(res)
        $('.client-wrapper')[doRenderMethod(isValid)]();
        $('#no-results')[doRenderMethod(!isValid)]();
        if(hasResults(res)) {
            $('#uf').text(res.uf);
            res.clientes.map(cliente => $('.client-wrapper').append(userCard(cliente)))
        }
    });


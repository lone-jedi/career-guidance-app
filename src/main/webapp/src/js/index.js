import Stepper from 'bs-stepper';

window.addEventListener("load", function() {
    let previousStepBtn = document.querySelector('#previous-step-btn');
    let nextStepBtn = document.querySelector('#next-step-btn');
    let stepper = new Stepper(document.querySelector('.bs-stepper'));;


    previousStepBtn.addEventListener('click', function () {
        stepper.previous();
    });

    nextStepBtn[0].addEventListener('click', function () {
        stepper.next();
    });

});

<div class="bs-stepper">
    <div class="bs-stepper-header" role="tablist">
        <!-- your steps here -->
        <div class="step" data-target="#zno-part">
            <button type="button" class="step-trigger" role="tab" aria-controls="zno-part"
                    id="zno-part-trigger">
                <span class="bs-stepper-circle">1</span>
                <span class="bs-stepper-label">Обрати ЗНО</span>
            </button>
        </div>
        <div class="line"></div>
        <div class="step" data-target="#test-part">
            <button type="button" class="step-trigger" role="tab" aria-controls="test-part"
                    id="test-part-trigger">
                <span class="bs-stepper-circle">2</span>
                <span class="bs-stepper-label">Профорієнтаційний тест</span>
            </button>
        </div>
        <div class="line"></div>
        <div class="step" data-target="#result-part">
            <button type="button" class="step-trigger" role="tab" aria-controls="result-part"
                    id="result-part-trigger">
                <span class="bs-stepper-circle">3</span>
                <span class="bs-stepper-label">Результати</span>
            </button>
        </div>
    </div>
    <div class="bs-stepper-content">
        <!-- your steps content here -->
        <form action="/user/start/test" method="post" name="test-results">
            <div id="zno-part" class="content" role="tabpanel" aria-labelledby="zno-part-trigger">
                <!-- ZNO select section -->
                <h5 class="mt-5">Оберіть перше ЗНО</h5>
                <select class="form-select" aria-label="Default select example" name="first-zno">
                    <#list znos as zno>
                    <option value="${zno?counter}">${zno}</option>
                    </#list>
                </select>

                <h5 class="mt-5">Оберіть друге ЗНО</h5>
                <select class="form-select" aria-label="Default select example" name="second-zno">
                    <#list znos as zno>
                    <option value="${zno?counter}">${zno}</option>
                    </#list>
                </select>

                <h5 class="mt-5">Оберіть третє ЗНО</h5>
                <select class="form-select" aria-label="Default select example" name="third-zno">
                    <#list znos as zno>
                    <option value="${zno?counter}">${zno}</option>
                    </#list>
                </select>

                <div class="mx-auto mt-5" style="width: 200px;">
                    <input type="button" class="btn bg-primary text-white" id="next-step-btn" value="Далі">
                </div>
            </div>
            <div id="test-part" class="content" role="tabpanel"
                 aria-labelledby="test-part-trigger">
                <!-- Basic career guidance test -->
                <input type="hidden" name="test_id" value="13">
                <h5 class="mt-4">Какой-то вопрос номер 1</h5>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="question:1" value="1"
                           id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Ответ номер 1
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="question:1" value="2"
                           id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Ответ номер 2
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="question:1" value="3"
                           id="flexRadioDefault3">
                    <label class="form-check-label" for="flexRadioDefault3">
                        Ответ номер 3
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="question:1" value="4"
                           id="flexRadioDefault4">
                    <label class="form-check-label" for="flexRadioDefault4">
                        Ответ номер 4
                    </label>
                </div>

                <h5 class="mt-4">Какой-то вопрос номер 2</h5>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="1"
                           id="flexRadioDefault11" name="question:2">
                    <label class="form-check-label" for="flexRadioDefault11">
                        Ответ номер 1
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" value="2"
                           id="flexRadioDefault12" name="question:2">
                    <label class="form-check-label" for="flexRadioDefault12">
                        Ответ номер 2
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" value="3"
                           id="flexRadioDefault13" name="question:2">
                    <label class="form-check-label" for="flexRadioDefault13">
                        Ответ номер 3
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" value="4"
                           id="flexRadioDefault14" name="question:2">
                    <label class="form-check-label" for="flexRadioDefault14">
                        Ответ номер 4
                    </label>
                </div>

                <input type="radio" name="test" id="test1" value="Test 1">Test 11
                <input type="radio" name="test" id="test2" value="Test 2">Test 22
                <input type="radio" name="test" id="test3" value="Test 3">Test 33
                <input type="radio" name="test" id="test4" value="Test 4">Test 44

                <div class="mx-auto" style="width: 500px;">
                    <input type="button" class="btn bg-primary text-white" id="previous-step-btn"
                           value="Повернусись">
                    <input type="submit" class="btn bg-primary text-white"
                           value="Завершити та показати результати">
                </div>
            </div>

            <div id="result-part" class="content" role="tabpanel" aria-labelledby="result-part-trigger">
                <!-- Result of test & list of universities -->
            </div>
        </form>
    </div>
</div>
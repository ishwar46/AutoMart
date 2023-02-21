const inputKey = document.getElementById('inputKey');
const inputValue = document.getElementById('inputValue');
const btnInsert = document.getElementById('btnInsert');
const lsOutput = document.getElementById('lsOutput');
const btnAllDelete = document.getElementById('btnAllDelete');
const autoFILL = document.getElementById('autoFILL');
const inputDelKey = document.getElementById('inputDelKey');
const btnDelete = document.getElementById('btnDelete');
const inputReadDataKey = document.getElementById('inputReadDataKey');
const btnReadData = document.getElementById('btnReadData');
const readedDataHere = document.getElementById('readedDataHere');

btnInsert.onclick = function () {
    const key = inputKey.value;
    const value = inputValue.value;

    if (key && value) {
        localStorage.setItem(key, value);
        location.reload();
    }

    else {
        alert("Must Enter Vehicle Number");
    }
};

for (i = 0; i < localStorage.length; i++) {
    const key = localStorage.key(i);
    const value = localStorage.getItem(key);

    lsOutput.innerHTML += `
    <hr />
    Vehicle Number is: ${key} <br /><br />
    Task to do is: ${value}<br />
    `;

}
if (localStorage.length != 0) {
    document.getElementById('avialRecords').innerHTML += `
    Taks to do
    `;
}

if (localStorage.length == 0) {
    btnAllDelete.style.display = "none";
    autoFILL.innerHTML += `
       Add task to do
    `;
}

btnReadData.onclick = function () {

    const inputReadDataKeyNew = inputReadDataKey.value;
    const readeddData = localStorage.getItem(inputReadDataKeyNew);

    if (inputReadDataKeyNew) {
        if (readeddData) {
            readedDataHere.innerHTML += `
            Task of requested Vehicle Number is: ${readeddData}
        `;
        } else {
            readedDataHere.innerHTML = `
            <div class="alert alert-warning" role="alert">
                No task found with the requested ID.
            </div>
        `;
        }
    }

};

btnDelete.onclick = function () {
    const inputDelKeyD = inputDelKey.value;

    if (inputDelKey) {
        localStorage.removeItem(inputDelKeyD);
        location.reload();
    }
};

btnAllDelete.onclick = function () {
    localStorage.clear();
    location.reload();
};


document.addEventListener("DOMContentLoaded", function (event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId),
            nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId),
            headerpd = document.getElementById(headerId)

        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            toggle.addEventListener('click', () => {
                // show navbar
                nav.classList.toggle('show')
                // change icon
                toggle.classList.toggle('bx-x')
                // add padding to body
                bodypd.classList.toggle('body-pd')
                // add padding to header
                headerpd.classList.toggle('body-pd')
            })
        }
    }

    showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink() {
        if (linkColor) {
            linkColor.forEach(l => l.classList.remove('active'))
            this.classList.add('active')
        }
    }
    linkColor.forEach(l => l.addEventListener('click', colorLink))

    // Your code to run since DOM is loaded and ready
});
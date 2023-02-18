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
        alert("Must Enter ID");
    }
};

for (i = 0; i < localStorage.length; i++) {
    const key = localStorage.key(i);
    const value = localStorage.getItem(key);

    lsOutput.innerHTML += `
    <hr />
    ID is: ${key} <br /><br />
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
            Task of requested ID is: ${readeddData}
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
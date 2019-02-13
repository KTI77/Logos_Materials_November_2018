// alert('sdf');

function clickMe() {
    console.log('Clicked');
}

function changeStyle() {
    document.getElementById('h2Elem').style.color = '#216756';
    document.getElementById('pElem').style.backgroundColor = 'orange';
    document.getElementById('spanElem')
        .setAttribute('style', 'font-size : 30px; color : blue;');
    document.getElementById('btnElem').style.transform = 'rotate(15deg)';
}


document.getElementById('btnSearch')
    .addEventListener('click', function() {
        let searchValue = document.getElementById('searchValue');
        console.log(searchValue.value);

        //let searchURL = 'https://stackoverflow.com/search?q=' + searchValue.value;
        // https://www.google.com/search?q=
        let searchURL = 'https://www.google.com/search?q=' + searchValue.value;
        console.log(searchURL);
        window.open(searchURL);
    });


function createClock() {
    let today = new Date();
    //console.log(today);

    let h = today.getHours();
    let m = today.getMinutes();
    let s = today.getSeconds();

    h = checkTime(h);
    m = checkTime(m);
    s = checkTime(s);

    //console.log(h + ':' + m + ':' + s);
    document.getElementById('clock').innerHTML = h + ':' + m + ':' + s;
    setTimeout(createClock, 500);
}

function checkTime(i) {
    if (i < 10) {
        i = '0' + i;
    }
    return i;
}

createClock();

// setTimeout(function() {
//     console.log('afsdfsd');
// }, 2000);

// setInterval(function() {
//     console.log('sdfsdfgsd');
// }, 1000);
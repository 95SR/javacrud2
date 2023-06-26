window.onload = () => {
    getAllStudents()
}

const getAllStudents= () => {
    fetch('/api/v1/students')
    .then((res) => {
        return res.json()
    }).then((data)=> {
        console.log(data)
        showData(data)
    })
}

const showData = (data) => {
    let tab =
    `<tr>
        <th>학번</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>전화번호</th>
        <th>거주지역</th>
    </tr>`
    for (let index = 0; index < data.length; index++) {
        tab+= `<tr>
        <td>${data[index].id}</td>
        <td>${data[index].name}</td>
        <td>${data[index].sex}</td>
        <td>${data[index].age}</td>
        <td>${data[index].phone}</td>
        <td>${data[index].location}</td>
        </tr>`
    }

    document.getElementById("studentsData").innerHTML = tab;
    
}

const searchStudent = () => {
    
    let form = document.getElementById("searchForm")
    let searchId = document.getElementById("searchId").value
    console.log(form)
    console.log(searchId)
}





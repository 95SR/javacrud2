const addForm = document.getElementById("addForm")

const fetchData = async(url) => {
    const res = await fetch(url)
    const success = res.ok
    let dataStudent;
    if(success){        
        jsonres = await res.json()
        dataStudent = jsonres.data
        
    }else{
        console.log("not found") 
        dataStudent = null
    }
    return dataStudent
    
    
}

const postData = async(url,data) => {
    const res = await fetch(url,{
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: data
        }
    )
    const success = res.ok
    let responseData;
    if(success){
        responseData= await res.json()
    }else{
        window.alert("error")
        responseData=null
    }

    return responseData

    
    
}

const getAllStudents= async () => {
    // fetch('/api/v1/students')
    // .then((res) => {
    //     return res.json()
    // }).then((data)=> {
    //     console.log(data.studentList)
    //     showData(data)
    // })

    let url = '/api/v1/students'
    const data = await fetchData(url)
    
    showData(data)
}

const findStudent= async () => {
    
    let searchId = document.getElementById("searchId").value
    if(searchId == ""){
        window.alert("학번을 입력하셔야 합니다.")
        
    } else{
        let url = `/api/v1/student/${searchId}`
        const data = await fetchData(url)
        
        showData(data)
    }

    
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
    if (data == null){
        tab+= `<tr>
        <td>no data</td>
        
        </tr>`
    }
    else if( data.length > 1){
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

    } else {
        tab+= `<tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.sex}</td>
            <td>${data.age}</td>
            <td>${data.phone}</td>
            <td>${data.location}</td>
            </tr>`
    }
    

    document.getElementById("studentsData").innerHTML = tab;
    
}



getAllStudents()


const searchStudent =  () => {
    
     findStudent() 
   
}

addForm.addEventListener("submit", async (e) => {
    e.preventDefault()
    
})

const addStudent = async () => {
    let url = '/api/v1/students'
    let addForm = document.getElementById("addForm")
    let length = addForm.length
    let jsonData= "{"

    for (i = 0; i< length - 1; i++){
        if(i>0){
            jsonData+= ","
        }
        jsonData+= "\"" + addForm[i].name + "\":\"" +addForm[i].value + "\"" 
    }

    jsonData+="}"
    
    //console.log(jsonData)

    const res = await postData(url,jsonData)
    console.log(res)
    const success = res.success
    if(success){
        window.alert("학생이 등록되었습니다.")
        location.reload()
        
        
    }else{
        window.alert("아이디가 중복됩니다.\n다른 아이디를 입력해주세요.")
        
    }
}




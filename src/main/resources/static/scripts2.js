window.addEventListener("load", ()=> {
    console.log("load")
    getAllStudents()
})

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
   

    let url = '/api/v1/students'
    const data = await fetchData(url)
    
    showData(data)
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
            tab+= `<tr id=${index}>
            <div>
            <td >${data[index].id}</td>
            <td>${data[index].name}</td>
            <td>${data[index].sex}</td>
            <td>${data[index].age}</td>
            <td>${data[index].phone}</td>
            <td>${data[index].location}</td>
            
            </div>
            
            <td><button onclick="editStudent(${index})" >수정</button></td>
           
            <td><button onclick="delStudent(${index})">삭제</button></td>
            </tr>
            `
        }

    } else {
        tab+= `<tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.sex}</td>
            <td>${data.age}</td>
            <td>${data.phone}</td>
            <td>${data.location}</td>
            <td><button onclick="editStudent()">수정</button></td>
            
            <td><button onclick="delStudent()">삭제</button></td>
            </tr>`
    }
    

    document.getElementById("studentsData").innerHTML = tab;
    
}

const searchStudent =  async (e) => {
   
     e.preventDefault()
     console.log("test")
     let searchId = document.getElementById("searchId").value
    
    if(searchId == ""){
        window.alert("학번을 입력하셔야 합니다.")
        
    } else{
        let url = `/api/v1/student/${searchId}`
        const data = await fetchData(url)
        
        showData(data)
    }
 
   
}

const addStudent = async (e) => {
    e.preventDefault()
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

const reload = () => {
    location.reload()
}

const searchForm = document.getElementById("searchForm");

const editStudent = (key) => {
    const form = document.getElementById("addForm")
    for(i=0 ; i< form.length-1 ; i++){
        power = Math.pow(2,i)
        console.log(power)
        editValue = document.getElementById(key).childNodes[power+1].textContent
        console.log(editValue)
        form[i].value = document.getElementById(key).childNodes[power+1].textContent
    }
    console.log(form)
    document.getElementById("addTitle").innerHTML="학생 정보 수정"
    document.getElementById("addBtn").innerHTML="저장"

    
}

const delStudent = async (key) => {
    studentName = document.getElementById(key).childNodes[3].textContent
    studentId = document.getElementById(key).childNodes[1].textContent
    
    if (confirm(`${studentName}학생을 삭제하시겠습니까?`)){
        const res = await fetch(`/api/v1/student/${studentId}`,{
            method:"delete"
        })
        
        location.reload()
    }
    
}

addForm.addEventListener("submit", addStudent)
searchForm.addEventListener("submit", searchStudent)


console.log("pass")
document.addEventListener("DOMContentLoaded", function(){
    this.getElementById("imgfile").addEventListener("change", (e)=>{
        if(e.target.files && e.target.files[0]){ //파일이 있으면
            const reader = new FileReader();//파일 리더 객체를 만들고
            reader.onload = function(e){ //웹페이지 상에 파일 로드가 완료되었다면
                elemId("preview").src = e.target.result //이미지 태그의 src값으로 로드된 파일을 설정한다.
            }
            reader.readAsDataURL(e.target.files[0]) //설정된 파일 데이터를 읽어들인다.
        }else{
            elemId("preview").src = "" //취소를 누르면 등록된 이미지도 리셋됨
        }
    })
    elemId("save").addEventListener("click", function(){
        const formData = new FormData()
        formData.append("name", elemId("name").value)
        formData.append("debutYear", elemId("debut").value)
        formData.append("company", elemId("company").value)
        formData.append("img", elemId("imgfile").files[0])
        console.log(formData.get("name"));
        console.log(formData.get("debutYear"));
        console.log(formData.get("company"));
        console.log(formData.get("img"));
        axios.put("http://localhost:8585/api/artist/group/insert", formData)
        .then(function(result){
            console.log(result)
        })
        .catch(function(err){
            console.log(err)
        })
    })  
})
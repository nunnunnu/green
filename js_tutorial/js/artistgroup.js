let companyPage = 0
let keyword = ""

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
        console.log(formData.get("name"))
        console.log(formData.get("debutYear"))
        console.log(formData.get("company"))
        console.log(formData.get("img"))
        axios.put("http://localhost:8585/api/artist/group/insert", formData)
        .then(function(result){
            console.log(result)
        })
        .catch(function(err){
            console.log(err)
        })
    })
    elemId("company_sel").addEventListener("click", function(){
        getCompanyList();
    })
})

const baseURL = "http://localhost:8585/api"
function getCompanyList(page, keyword){
    let url = baseURL + "/company/list"
    let params = {} //axios방식
    if(page!=undefined && page != null){
        // url += "?page="+page //ajax방식. 
        params.page = page //axios방식
    }
    if(keyword!=undefined && keyword!=null && keyword!=""){
        // url += "&keyword="+keyword //ajax방식. 
        params.keyword = keyword //axios방식
    }
    console.log(params)
    axios.get(url, {params : params}).then(function(result){
        console.log(result)
        let tbodyContent=""
        const list = result.data.list
        list.forEach((item) => {
            tbodyContent += 
                '<tr>'+
                    '<td>'+item.pubSeq+'</td>'+
                    '<td>'+item.pubName+'</td>'+
                    '<td>'+
                        '<button onclick="selectCompany('+item.pubSeq+', \''+item.pubName+'\')">선택</button>'+
                    '</td>'+
                '</tr>'
        });
        let pagers =""
        console.log(tbodyContent)
        for(let i=0;i<result.data.totalPage;i++){
            // pagers += '<button onclick="getCompanyList('+i+', \''+elemId("search_keyword").value+'\')">'+(i+1)+'</button>'
            pagers += `<button onclick="getCompanyList(${i},'${elemId("search_keyword").value}')">${i+1}</button>`
            //jsp와 함께 사용하면 밑의 방법은 구분이 어려움.
        }
        document.querySelector(".company_popup tbody").innerHTML = tbodyContent
        document.querySelector(".popup_pager_area").innerHTML = pagers
    })
    elemId("search_btn").addEventListener("click", function(){
        getCompanyList(0, elemId("search_keyword").value)
    })
} 
// getCompanyList(null, "쏘스")

function selectCompany(seq, name){
    elemId("company").value = seq    
    elemId("company_name").innerHTML = name        
}
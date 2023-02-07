
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("genre_popup_btn").addEventListener("click", function () {
        document.getElementById("genre_add_wrap").style.display = "block";
    });
    elemId("genre_add_form").addEventListener("submit", (e) => {
        e.preventDefault()
    })
    elemId("genre_add_btn").addEventListener("click", function () {
        let name = elemId("genre_name").value;
        // alert(name);
        axios.put("http://localhost:8585/api/genre/add?name=" + name)
            .then((result) => {
                // 성공시 (응답코드 100~399)
                console.log(result)
                if (result.data.status) {
                    alert(result.data.message);
                    elemId("genre_add_wrap").style.display = "";
                    loadGenreList();
                    elemId("genre_name").value = "";
                    elemId("add_err_msg").innerHTML = "";
                } else {
                    elemId("add_err_msg").innerHTML = result.data.message;
                }
            })
            .catch((error) => {
                // 실패시 (응답코드 400~599)
                console.log(result)
            })
    })
    // DOMContentLoaded - HTML 파일의 모든 내용을 DOM으로 로드 완료한 시점
    // 브라우저에서 HTML을 모두 로드 한 시점
    loadGenreList();
    // form 태그의 기본으로 설정되어 있는 요청 기능을 제거하는 코드.
    document.getElementById("search_area").addEventListener("submit", function (event) {
        // event - 이벤트 파라미터, submit 이벤트에 대한 정보를 담고 있음.
        event.preventDefault();
    })
    document.getElementById("search").addEventListener("click", function () {
        const keyword = document.getElementById("keyword").value
        loadGenreList(0, keyword);
    })
    elemId("genre_add_close").addEventListener("click", function(){
        if(!confirm("창을 닫으시겠습니까? \n입력된 내용은 사라집니다.")){
            return
        }
        elemId("genre_name").value = ""; //입력값 비우기
        elemId("genre_add_wrap").style.display = ""; // 입력창의 display를 기존상태로 돌림.
        elemId("add_err_msg").innerHTML = "";
    })

    elemId("genre_update_form").addEventListener("submit", (e)=>{e.preventDefault()})
    elemId("genre_update_btn").addEventListener("click", function(){
        elemId("genre_update_wrap").style.display = "block"
        let no = elemId("genre_update_seq").value
        let name = elemId("genre_update_name").value
        axios.patch("http://localhost:8585/api/genre/update?no="+no+"&name="+name)
        .then(function(result){
            if(result.data.updated == false){ //업데이트 실패
                elemId("update_err_msg").innerHTML = result.data.message
            }else{
                alert("장르 정보가 수정되었습니다.")
                //입력 초기화
                elemId("update_err_msg").innerHTML= ""
                elemId("genre_update_seq").value= ""
                elemId("genre_update_name").value= ""
                elemId("genre_update_wrap").style.display = ""
                elemId("update_err_msg").innerHTML = ""
                //리스트 재로드
                loadGenreList()
            }
        })
    })
    elemId("genre_update_close").addEventListener("click", function(){
        if(!confirm("창을 닫으시겠습니까? \n입력된 내용은 사라집니다.")){
            return
        }
        elemId("genre_update_name").value = "" //입력값 비우기
        elemId("genre_update_seq").value = "" //입력값 비우기
        elemId("genre_update_wrap").style.display = "" // 입력창의 display를 기존상태로 돌림.
        elemId("update_err_msg").innerHTML = ""
    })

});

function deleteCategory(no) {
    if (!confirm("카테고리를 삭제하시겠습니까?")) return;
    // alert(no+"번 카테고리 삭제");
    axios.delete("http://localhost:8585/api/genre/delete?genre_no=" + no)
        .then(function (result) {
            console.log(result);
            alert(result.data.message);
            loadGenreList();
        })
}

function genreDetail(no){
    elemId("genre_update_wrap").style.display = "block"
    axios.get("http://localhost:8585/api/genre/detail?genre_no="+no)
    .then(function(result){
        console.log(result)
        elemId("genre_update_seq").value=result.data.no
        elemId("genre_update_name").value=result.data.name
    })
}

// js 는 기본적으로 () null 값이기 때문에 null 과 undefined 를  0 으로 설정해줘야 한다.
// result(변수명 a라고 해도됨) 란 responseEntity 의 응답결과 return
function loadGenreList(page, keyword) {
    if (page == null || page == undefined) page = 0
    if (keyword == null || keyword == undefined) keyword = ""
    axios.get("http://localhost:8585/api/genre/list?page=" + page + "&keyword=" + keyword)
        .then(function (result) {
            const genreList = result.data.list;
            console.log(genreList)
            let tbody_content = "";
            for (let i = 0; i < genreList.length; i++) {
                tbody_content += '<tr>' +
                    '<td>' + genreList[i].genreSeq + '</td>' +
                    '<td>' +
                    '<button class="genre_name" onclick="genreDetail('+genreList[i].genreSeq+')">' + genreList[i].genreName + '</button>' +
                    '</td>' +
                    '<td>' +
                    '<button onclick="deleteCategory(' + genreList[i].genreSeq + ')">삭제</button>' +
                    '</td>' +
                    '</tr>'
            }
            document.querySelector("#list_table > tbody").innerHTML = tbody_content;
            const totalPage = result.data.totalPage;
            const currentPage = result.data.currentPage;
            let pager_content = "";
            for (let i = 0; i < totalPage; i++) {
                if (i == currentPage) {
                    pager_content += '<button class="current" onclick="loadGenreList(' + i + ')">' + (i + 1) + '</button>'
                } else {
                    pager_content += '<button onclick="loadGenreList(' + i + ')">' + (i + 1) + '</button>'
                }
            }
            document.getElementById("pager_area").innerHTML = pager_content;
        });
}
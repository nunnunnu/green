package data;

// MemberInfo, PostComment, PostInfo 객체의 파일 입출력을
// 다형성 원리를 활용하여 일괄 처리 하기 위한 인터페이스
public interface BoardData {
    // 데이터 String으로부터 객체 값으로 변환하는 기능
    public void parseDataString(String dataStr) throws Exception;
    // 객체 값으로부터 데이터 String으로 변환하는 기능
    public String makeDataString();
}

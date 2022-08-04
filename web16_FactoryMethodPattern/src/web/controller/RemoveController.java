package web.controller;
/*
 * AddController... 실체 클래스 ... 구상객체
 * 
 * Component
 * ::
 * 인터페이스 기반으로 만들어진 재사용성 강한 자바 클래스
 */
public class RemoveController implements Controller{

	@Override
	public String handle() {
		/*
		 * 1. 폼값 받아서
		 * 2. VO 생성
		 * 3. biz 로직 호출
		 * 4. binding
		 * 5. navigation
		 */
		System.out.println("RemoveController ... Register... logic ...");
		return "remove_result.jsp";
	}
	
}

package servlet.controller;

/*
 * Component를 생성하는 공장
 * 싱글톤으로 작성
 * 서버클라이언트가 보내는 Command값에 따라서 생성되는 Component가 달라진다.
 */
public class UserControllerFactory {
	private static UserControllerFactory factory = new UserControllerFactory();

	private UserControllerFactory() {
		System.out.println("UserControllerFactory 싱글톤");
	}

	public static UserControllerFactory getInstance() {
		return factory;
	}

	// Component 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;

		if (command.equals("login")) {
			controller = new LoginController();
		} else if(command.equals("logout")) {
			controller = new LogoutController();
		}

		return controller;
	}
}

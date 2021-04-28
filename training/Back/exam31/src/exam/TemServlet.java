package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemServlet
 */
@WebServlet("/ten")			//어노테이션으로 /ten 있으면 주소에 /ten가능 3.0이상 버전에서는 web.xml 파일이 필요없음.
public class TemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		//나는 이런 타입의 응답을 보낼 것이다.
		PrintWriter out = response.getWriter();	//프린트용 통로
		out.println("<h1>1-10까지 출력!!</h1>");	//print나 println이나 상관없음 줄안바뀐다.
		for(int i=1;i<=10;i++) {
			out.print(i + "<br>");		//<br> 태그 있어야 줄바꿈.
		}
		out.close();
	}
}

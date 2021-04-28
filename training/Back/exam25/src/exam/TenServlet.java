package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
public class TenServlet extends HttpServlet {		//어노테이션 없음
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
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

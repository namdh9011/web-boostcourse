# 3) Web API 실습-2

**들어가기 전에**

이번 시간엔 서블릿을 이용해 Web API를 작성해 보도록 하겠습니다.

참고로 JDBC 수업 시간에 배웠던 RoleDao도 이번 시간에 재활용됩니다.

 



------

**학습 목표**

1. Servlet을 이용해 Web API를 작성할 수 있습니다.
2. 객체를 JSON문자열로 변환시킬 수 있습니다.



 

------

**핵심 개념**

- JSON
- ObjectMapper
- URL pattern에서 wildcard(*)



 

------

**학습하기**

**실습코드**

RoleByIdServlet.java

```java
package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoleByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		String pathInfo = request.getPathInfo(); // /roles/{roleId}
		String[] pathParts = pathInfo.split("/");
		String idStr = pathParts[1];
		int id = Integer.parseInt(idStr);

		RoleDao dao = new RoleDao();

		Role role = dao.getRole(id);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
```



 

------

**생각해보기**

자바 서블릿은 보통 하나의 URL에 대한 처리만 합니다.

그런데 이번 실습을 보면 Role과 관련된 다양한 URL이 필요했고, 이를 처리하기 위한 클래스가 여러 개 필요했습니다.

객체지향은 관련된 여러 개의 기능을 하나로 모으는 것이 중요합니다.

그런데, 관련된 여러 개의 URL 처리를 여러 개의 서블릿으로 나눠서 하고 있습니다.

이러한 문제를 해결하려면 어떻게 해야 할까요?



 

------

**참고 자료**

[**[참고링크\] JDBC Basics**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
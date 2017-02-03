package cn.vaf714.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class EncodingFilter implements Filter {

	private String charEncoding = null;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		charEncoding = fConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response = new MyResponse((HttpServletResponse) response);
		request.setCharacterEncoding(charEncoding);
		response.setCharacterEncoding(charEncoding);

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
}

class MyResponse extends HttpServletResponseWrapper {
	HttpServletResponse response;

	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		response.setContentType("text/html");
		return super.getWriter();
	}

}
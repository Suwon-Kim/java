package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public interface ICmd {
	void action(HttpServletRequest request);
}

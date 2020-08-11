package org.docs.cmds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICMD {
	void action(HttpServletRequest request, HttpServletResponse response);
}

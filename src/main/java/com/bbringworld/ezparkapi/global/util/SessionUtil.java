package com.bbringworld.ezparkapi.global.util;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    private static final String LOGIN_ADMIN = "ADMIN_USER";

    /**
     * 로그인한 관리자 id를 세션에서 꺼낸다.
     * 로그인 하지 않았다면 null이 반환된다
     *
     * @param session 사용자의 세션
     * @return 로그인한 사장님 id 또는 null
     */
    public static String getLoginAdminId(HttpSession session) {
        return (String)session.getAttribute(LOGIN_ADMIN);
    }

    /**
     * 로그인한 관리자 id를 세션에 저장한다.
     *
     * @param session 사용자의 세션
     * @param id      로그인한 사장님 id
     */
    public static void setLoginAdminId(HttpSession session, Long id) {
        session.setAttribute(LOGIN_ADMIN, id);
    }

    /**
     * 해당 세션의 정보를 모두 삭제한다.
     *
     * @param session 사용자의 세션
     */
    public static void clear(HttpSession session) {
        session.invalidate();
    }

    /*public static void setSession(HttpSession session, User user) {
        if (user.getRole() == ADMIN) {
            SessionUtil.setLoginAdminId(session, user.getId());
        } else {
            SessionUtil.setLoginMemberId(session, user.getId());
        }
    }*/
}

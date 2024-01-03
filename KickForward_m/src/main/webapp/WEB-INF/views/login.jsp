<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jang.biz.model.User" %>
<%@ page import="net.sf.json.JSONObject" %>

<%
    // 모델에 담긴 loginUser 객체 가져오기
    User loginUser = (User) request.getAttribute("loginUser");

    // loginUser 객체가 null이 아닐 때 JSON으로 변환
    if (loginUser != null) {
    	JSONObject userJson = new JSONObject();
        userJson.put("id", loginUser.getId());
        userJson.put("name", loginUser.getName());
        userJson.put("zip", loginUser.getZip());
        userJson.put("addr1", loginUser.getAddr1());
        userJson.put("addr2", loginUser.getAddr2());
        userJson.put("phone", loginUser.getPhone());
        userJson.put("email", loginUser.getEmail());
        userJson.put("license", loginUser.getLicense());
        userJson.put("billingKey", loginUser.getBillingKey());

        // JSON 데이터를 클라이언트로 출력
        out.print(userJson.toString());
    }
%>
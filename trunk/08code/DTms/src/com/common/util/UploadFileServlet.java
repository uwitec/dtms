package com.common.util;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadFileServlet extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 转发请求
	 * 
	 * @param request
	 * @param url
	 * @throws IOException
	 * @throws ServletException
	 */
	public void forward(HttpServletRequest request,
			HttpServletResponse response, String url) throws ServletException,
			IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * 跳转页面
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 */
	public void sendRedirect(HttpServletRequest request,
			HttpServletResponse response, String url) throws IOException {
		if (request != null) {
			url = request.getContextPath() + url;
		}
		response.sendRedirect(url);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 新建一个SmartUpload对象
			SmartUpload upload = new SmartUpload();
			// 上传初始化
			upload.initialize(this.getServletConfig(), request, response);
			// 设置上传文件大小
			// 1、设置每次上传文件的最大长度
			// 无法判断上传文件大小。
			int FileSizes = 1024 * 10000000; // 设置上传文件大小为1m
			upload.setMaxFileSize(FileSizes);
			// 2、设置总上传文件的长度
			// upload.setTotalMaxFileSize(102400000);
			// 3、设置上传文件的格式（通过扩展名限制）
			//
			String uploadStr = "xls,gif,jpg,JPG,JPEG,jpeg,GIF,doc,pdf,txt,DOC,PDF,TXT,BMP,bmp,PNG,png,rar,7z,doc,docx";
			upload.setAllowedFilesList(uploadStr);
			// 4、设置禁止上传的文件类型（通过扩展名限制）rar,7z,doc,docx,xls
			upload.setDeniedFilesList("exe,lab,htm,html");
			// 上传文件
			upload.upload();
			String fileExtStr = null;
			for (int i = 0; i < upload.getFiles().getCount(); i++) {
				com.jspsmart.upload.SmartFile file = upload.getFiles().getFile(
						i);

				if (file.isMissing()) {
					// 若文件不存在则继续
					String str = "请选择要上传的文件！";
					request.setAttribute("str", str);
					this.forward(request, response,
							"/ueadmin_ue/include/upload.jsp");
					// continue;
				} else {
					// 生成文件名
					String fileName = "/upload/flies/"
							+ System.currentTimeMillis() + "."
							+ file.getFileExt();
					fileExtStr = file.getFileExt();
					file.saveAs(fileName);
					// System.out.println("fileName="+fileName);
					String companyLogon = fileName;
					HttpSession session = request.getSession();
					String type = upload.getRequest().getParameter("type");
					if ("f".equals(type)) {
						/*
						 * if(session.getAttribute("files")!=null){ String
						 * companyLogon1 = ""; companyLogon1 =
						 * session.getAttribute("files").toString();
						 * if(companyLogon1!=null&&companyLogon1.length()>0){
						 * companyLogon = companyLogon1 +","+ fileName; } }
						 */
						session.setAttribute("files", companyLogon);
						if (fileExtStr != null && fileExtStr.length() > 0) {
							if (fileExtStr.equals("rar")) {
								request.setAttribute("fileExtStr",
										"/images/archive.gif");
							} else if (fileExtStr.equals("word")) {
								request.setAttribute("fileExtStr",
										"/images/msword.gif");
							} else if (fileExtStr.equals("xls")) {
								request.setAttribute("fileExtStr",
										"/images/msexcel.gif");
							}
						}
					} else {
						/*
						 * if(session.getAttribute("companyLogon")!=null){
						 * String companyLogon1 = ""; companyLogon1 =
						 * session.getAttribute("companyLogon").toString();
						 * if(companyLogon1!=null&&companyLogon1.length()>0){
						 * companyLogon = companyLogon1 +","+ fileName; } }
						 */
						session.setAttribute("companyLogon", companyLogon);
					}

					String str = "上传成功！";
					request.setAttribute("str", str);
					request.setAttribute("fileName", fileName);
					if ("f".equals(type)) {
						this.forward(request, response,
								"/ueadmin_ue/include/Fileupload.jsp");
					} else {
						this.forward(request, response,
								"/ueadmin_ue/include/upload.jsp");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			String str = "上传的文件类型不匹配或文件大小超出规定限制！";
			request.setAttribute("str", str);
			this.forward(request, response, "/ueadmin_ue/include/upload.jsp");
		}

	}

}

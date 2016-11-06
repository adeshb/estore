package com.estore.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private static final Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	//ResRoleService resRoleService;

	/**
	*/
	@RequestMapping(value = "/estore", method = RequestMethod.GET)
	public String estore() {
		return "index.html";
	}

	/**
	*/
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}



	/**
	*/
	@RequestMapping(value = "/searchCFMaster", method = RequestMethod.GET)
	public String searchCFMaster(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Date currDate = new Date();
		model.addAttribute("endDate", sdf.format(currDate));
		model.addAttribute("startDate", sdf.format(calendar.getTime()));
		return "searchcfmaster";
	}

	/**
	 */
	@RequestMapping(value = "/projectDetail", method = RequestMethod.GET)
	public ModelAndView projectDetail(HttpServletRequest req) {
		ModelAndView model = new ModelAndView("projectDetail");
		if (req.getParameter("pc") != null) {
			model.addObject("pc", req.getParameter("pc"));

		}
		return model;
	}

	/**
	 */
/*	@RequestMapping(value = "/overallCFCoverage", method = RequestMethod.GET)
	public String overallCfCoverage(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Date currDate = new Date();
		model.addAttribute("endDate", sdf.format(currDate));
		model.addAttribute("startDate", sdf.format(calendar.getTime()));

		return "overallCFCoverage";
	}*/

	/**
	 */
	/*@RequestMapping(value = "/buWiseCoverage", method = RequestMethod.GET)
	public ModelAndView buWiseCoverage(HttpServletRequest req) {
		ModelAndView model = new ModelAndView("buWiseCoverage");
		String startDate, endDate = null;
		if (req.getParameter("u") == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date currDate = new Date();
			startDate = sdf.format(calendar.getTime());
			endDate = sdf.format(currDate);
		} else {
			startDate = req.getParameter("sd");
			endDate = req.getParameter("ed");
			model.addObject("sltdBuCde", req.getParameter("u"));
		}
		model.addObject("startDate", startDate);
		model.addObject("endDate", endDate);

		return model;
	}*/

	/**
	 */
	/*@RequestMapping(value = "/customerCoverage", method = RequestMethod.GET)
	public String customerCoverage(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Date currDate = new Date();
		model.addAttribute("endDate", sdf.format(currDate));
		model.addAttribute("startDate", sdf.format(calendar.getTime()));

		return "customerCoverage";
	}*/

	/**
	 */
/*	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/AuthenticationCheck", method = RequestMethod.POST)
	public ModelAndView authenticationCheck(HttpServletRequest req) {
		System.out.println("Inside  AuthenticationCheck");
		ModelAndView model = new ModelAndView("loginPage");

		AuthenticationCheck ldapCheck = new AuthenticationCheck();

		String empId = req.getParameter("empId");
		String userId = empId.concat("@ind.zensar.com");
		String empPass = req.getParameter("empPass");
		if (empId != null && empId != "" && empPass != null && empPass != "") {
			System.out.println("inside if...");

			EmployeeVO empDO = new EmployeeVO();
			*//** BYPASS LDAP HERE ***//*
			// empDO.setEmpId("46450");
			// empDO.setDisplayName("Adesh");
			empDO.setEmpId(userId);
			empDO.setEmpPass(empPass);

			empDO = ldapCheck.getLdapEmployee(empDO);

			if (empDO != null) {
				System.out.println("authenticated from LDAP...");

				// Set Data retrieved from LDAP
				req.getSession().setAttribute("Emp", empDO);
				req.getSession().setAttribute("displayName", empDO.getDisplayName());
				System.out.println("empDO.getEmpId() : " + empDO.getEmpId());

				// Rerieve and set Resource's role name
				Integer empCode = Integer.valueOf(empDO.getEmpId());
				CfResRole cfResRole = resRoleService.getRoleForRes(empCode);
				req.getSession().setAttribute("ResRole", cfResRole);

				System.out.println("cfResRole : " + cfResRole);
				if (cfResRole != null) {
					System.out.println("cfResRole.getCfRole().getCfRole() :" + cfResRole.getCfRole().getCfRole());
					req.getSession().setAttribute("role", cfResRole.getCfRole().getCfRole());
					// Forward to Home Page
					model.setViewName("home");
					model.addObject("home");
				} else {
					model.addObject("msg", "You are not authorized to access.");
					model.setViewName("logout");
				}
			} else {
				System.out.println("LDAP error..");
				model.addObject("msg", "Please check your credientials...");
				model.setViewName("logout");
				model.addObject("logout");
			}
		} else {
			System.out.println("LDAP error..");
			model.addObject("msg", "Please check your credientials...");
			model.setViewName("logout");
			model.addObject("logout");
		}
		return model;

	}
*/
	/**
	 */
	/*@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest req) {
		System.out.println("inside logout...");
		req.getSession().invalidate();
		req.setAttribute("msg", "logged-out successfully...");
		return "logout";
	}*/

	/*@RequestMapping("/download/{cfFormId}")
	public String download(@PathVariable("cfFormId") String cfFormId, HttpServletResponse response) {
		CfProjForm cfProjForm = uploadFormService.findProjFormByFormId(cfFormId);
		// Document doc = documentDao.get(documentId);
		String fileName = cfProjForm.getFileName();
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");

			if (fileName.endsWith(".xls"))
				response.setContentType("application/vnd.ms-excel");
			else if (fileName.endsWith(".xlsx"))
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

			InputStream myStream = uploadFormService.donwloadForm(cfFormId);
			OutputStream out = response.getOutputStream();

			IOUtils.copy(myStream, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/**
	 * Downloads the report as an Excel format.
	 * <p>
	 * Make sure this method doesn't return any model. Otherwise, you'll get an
	 * "IllegalStateException: getOutputStream() has already been called for
	 * this response"
	 */
	/*@RequestMapping(value = "/xls", method = RequestMethod.GET)
	public String getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
		System.out.println("Received request to download report as an XLS");

		// Delegate to downloadService. Make sure to pass an instance of
		// HttpServletResponse
		// excelService.downloadXLS(response);
		return null;
	}*/

	//@RequestMapping(value="/xls/{buCde}/{custCde}/{billCustCde}/{acctTypeId}/{focused}/{nonfocused}", method = RequestMethod.GET)
	/*public void getXLS(@PathVariable("buCde") String buCde, @PathVariable("custCde") String custCde, @PathVariable("billCustCde") String billCustCde,
			@PathVariable("acctTypeId") String acctTypeId, @PathVariable("focused") String focused,
			@PathVariable("nonfocused") String nonfocused, HttpServletResponse res) {
		ResponseEntity<List<CfProjMaster>> response = new ResponseEntity<List<CfProjMaster>>(HttpStatus.NO_CONTENT);
		try {
			logger.info("-------------- buCde:" + buCde);
			logger.info("-------------- custCde:" + custCde);
			logger.info("-------------- billCustCde:" + billCustCde);
			logger.info("-------------- acctTypeId:" + acctTypeId);
			logger.info("-------------- focused:" + focused);
			logger.info("-------------- nonfocused:" + nonfocused);

			String fileName = "CF-Master.xls";
			//String fileName = "CF-Master_Reg-"++"_BU-"++"_Cust-"++"_AcctType-"++"_Foc-"++"_NonFoc-"+;
			
			StopWatch watch = new StopWatch("IndexController: getXLS()");
			watch.start("searchProjByBuBillCustAndCustType()");
			List<CfProjMaster> projList = cfMasterService.searchProjByBuBillCustAndCustType(buCde, custCde, billCustCde,
					acctTypeId, focused, nonfocused);
			watch.stop();
			
			logger.info("projList size() **************** :"+projList.size());
			//Create Excel Sheet
			// Delegate to excelService. Make sure to pass an instance of
			// HttpServletResponse
			watch.start("downloadXLS()");
			excelService.downloadXLS(res, projList, fileName);
			watch.stop();
			
			logger.info(watch.prettyPrint());
			
			if (projList.isEmpty()) {
				response = new ResponseEntity<List<CfProjMaster>>(HttpStatus.NO_CONTENT);
			}
			response = new ResponseEntity<List<CfProjMaster>>(projList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<List<CfProjMaster>>(HttpStatus.EXPECTATION_FAILED);
		}
		//return null;
	}*/

}

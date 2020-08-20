package com.jang.board;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {
	 
	@Autowired
	private BoardService borderService;
	
	// 홈
	@RequestMapping({"/","home"})
	public String home() {
		
		return "home"; 
	}
	
	// 메인, 자유게시판
	@RequestMapping("/main")  
	public String getAll(Model model,
			@RequestParam("pageNum") int pageNum
			) {	 
		 
//		int pageNum = 1; 
//		
//		if(temp != 0) {
//			pageNum = temp;
//		} 
		 
//		System.out.println(pageNum);
		 
		int totalBoardCount = borderService.getTotalCount();
		
		int perPage = 10;
		
		int pageCount = totalBoardCount / perPage;
		
		if(totalBoardCount % perPage > 0){
			pageCount++;
		} 
		      
		model.addAttribute("pageNum", pageNum); 
		model.addAttribute("totalBoardCount",totalBoardCount);
		model.addAttribute("pageCount",pageCount);   
//		model.addAttribute("list", service.getAll());  
		model.addAttribute("list", borderService.getList(pageNum, perPage)); 
		
		return "main";    
	}     
	
	
	  
	// 추가 화면
	@RequestMapping("/insertBoard")
	public String insertBoard() {
		return "insert";  
	}   
	
	// 추가
	@RequestMapping(value="/doInsertBoard", method=RequestMethod.POST)
	public String doInsertBoard(
				@RequestParam("b_title") String b_title,
				@RequestParam("b_writer") String b_writer,
				@RequestParam("b_contents") String b_contents,
				@RequestParam("b_id") String b_id,
				MultipartHttpServletRequest request
			) { 
		
		try {
			Map<String, MultipartFile> map = request.getFileMap();
			
			System.out.println("제목은 ?" + b_title);
			System.out.println("아이디값 넘어오니?" + b_id);
			Board board = new Board();
			board.setB_title(b_title);
			board.setB_writer(b_writer);
			board.setB_contents(b_contents);
			board.setB_id(b_id); 
			
			for(int i = 0; i < map.size(); i++) {
				MultipartFile mFile = map.get("filename1");
				if(mFile != null && !mFile.getOriginalFilename().equals("")){
					if(i == 0) board.setFilename1(mFile.getBytes());
					
				    String root_path = request.getSession().getServletContext().getRealPath("/");  
				    String attach_path = "resources/upload/";
				    
				    UploadClass up = new UploadClass();
				    
				    String filename = mFile.getOriginalFilename(); 
				    
				    File f = new File(root_path + attach_path + filename);
				    try {
				    	mFile.transferTo(f); 
				    } catch (Exception e) {
				    	System.out.println(e.getMessage());
				    } 
					
				} 
			}  
			borderService.insertBoard(board);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
	
		
		 
		return "redirect:/main?pageNum=1"; 
	}
	
	// 수정
	@RequestMapping("/updateBoard")
	public String updateBoard(
			@RequestParam("b_num") int b_num,
			@RequestParam("b_title") String b_title,
			@RequestParam("b_writer") String b_writer,
			@RequestParam("b_contents") String b_contents
		) { 
		
		Board board = new Board();
		board.setB_num(b_num);
		board.setB_title(b_title);
		board.setB_writer(b_writer);
		board.setB_contents(b_contents);
		 
		borderService.updateBoard(board);
		return "redirect:/main?pageNum=1";
	} 
	
	// 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard( 
			@RequestParam("b_num") int b_num
		) {
		
		borderService.deleteBoard(b_num);  
		 
		return "redirect:/main?pageNum=1"; 
	}  
	 
	// 상세보기 화면
	@RequestMapping("/showDetail") 
	public String getOne(Model model,
			@RequestParam("b_num") int b_num) {
		 
		borderService.plusHit(b_num);
		
		model.addAttribute("list", borderService.getOne(b_num));
		 
		return "showDetail";
	}
	 
	// 검색
	@RequestMapping("searchAll")
	public String searchAll(Model model,
			@RequestParam("option") String option,
			@RequestParam("search_desc") String search_desc	) {
		
		model.addAttribute("list", borderService.searchAll(option, search_desc));
		
		return "main";
	}  
	
	// 통계 
	@RequestMapping("chart")
	public String getChart() {
		 
		return "chart";
	}
}

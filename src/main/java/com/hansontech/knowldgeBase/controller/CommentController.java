package com.hansontech.knowldgeBase.controller;
import com.hansontech.knowldgeBase.entity.Comments;
import com.hansontech.knowldgeBase.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@ControllerAdvice
@RequestMapping("/knowledge")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }
    // Handler method to handle list student request and return view
    @GetMapping("/create")
    //localhost:9090/knowledge/create
    public String listStudents(Model model) {
        //Create Comment object to hold student form data
        Comments comment = new Comments();
        model.addAttribute("comment", comment);
        return "comment";}

    @PostMapping("/view")
    //localhost:9090/knowledge/view
    public String viewComment(@ModelAttribute("comments") Comments comments) {
        //Create student object to hold student form data
        commentService.saveComments(comments);
        return "/posts";}

    @GetMapping("/viewPosts")
    //localhost:9090/knowledge/viewPosts
    public String viewComments(Model model){
        model.addAttribute("comments",commentService.getAllComment());
        return "/posts";}

    @PostMapping("/update/{id}")
    //localhost:9090/management/api/students/{id}
    public String updateStudent(@PathVariable Long id,
                              @ModelAttribute("comment") Comments comment, Model model) {
        //Get Comments from database by ID
        Comments existingComment = commentService.getCommentsById(id);
        existingComment.setId(id);
        existingComment.setFirstName(comment.getFirstName());
        existingComment.setLastName(comment.getLastName());
        existingComment.setEmail(comment.getEmail());
        existingComment.setComment(comment.getComment());
        //Save updated comment object
        commentService.updateComments(existingComment);
        return "/edit_student";}

    @GetMapping("/delete/{id}")
    //http://localhost:8080/comment/1
    public String deletePupil(@PathVariable Long id, Model model){
        commentService.deleteComments(id);
        return "/posts";
    }

    @GetMapping("")
    //localhost:8080/knowledge/viewPosts
    public String login(Model model){
        // model.addAttribute("details",commentService.getAllComment());
        return "/login";}

    @GetMapping("/list")
    //localhost:8080/knowledge/list
    public String listOfComments(Model model){
        model.addAttribute("comments",commentService.getAllComment());
        return "/list";}

//    @GetMapping("/")
//    //localhost:8080/knowledge/logout
//    public String logout(HttpServletRequest request) throws ServletException {
//       request.logout();
//        return "/";}
}


package com.heyong.lenrn_net.Controller;/**
 * Create By Yong
 */

import com.heyong.lenrn_net.POJO.User;
import com.heyong.lenrn_net.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *用户控制器
 *Create By Yong
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAll(HttpSession session){
        logger.info("id:{}",session.getAttribute("name"));
        return userService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllStudent")
    @ResponseBody
    public List<User> getAllStudent(){
        return userService.findAllStudent();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllTeacher")
    @ResponseBody
    public List<User> getAllTeacher(){
        return userService.findAllTeacher();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    @ResponseBody
    public User register(@RequestBody User user){
        logger.info("resigster-user:",user);
        return userService.register(user);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/updata")
    @ResponseBody
    public User updata(@RequestBody User user){
        logger.info("user:",user);
        return userService.updata(user);
    }

    public String getUserPassword(Integer userId){
        return userService.getPassword(userId).toString();
    }

    /**
     *判断用户是否存在
     * @param userId
     * @return
     */
    public boolean UserOrExist(Integer userId){
        List<User> userList = userService.findAll();
        for(User user:userList){
            if(user.getUserId().equals(userId)){
                return true;
            }
        }
        return false;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> Login(HttpSession session,@RequestParam("userId")Integer userId, @RequestParam("userPassword")String userPassword){
        logger.info("userId:{},userPassword:{}",userId,userPassword);

        HashMap<String,String> map = new HashMap<>();
        if(UserOrExist(userId)){
            if(userPassword.equals(getUserPassword(userId))){
                User user = userService.findById(userId);
                session.setAttribute("userId",userId);
                session.setAttribute("userName",user.getUserName());
                session.setAttribute("userCategory",user.getUserCategory());
                session.setAttribute("sessionID",session.getId());
                logger.info("登录成功！,userId:{},userName:{},sessionID:{}",userId,session.getAttribute("userName"),session.getAttribute("sessionID"));
                map.put("state","success");
                map.put("sessionID",session.getId());
                return map;
            }else {
                logger.warn("密码错误！");
                map.put("state","密码错误！");
                return map;
            }
        }else {
            logger.warn("用户不存在");
            map.put("state","用户不存在!");
            return map;
        }
    }

    //判断用户是否登录
    @CrossOrigin(origins = "*")
    @RequestMapping("/isLogin")
    @ResponseBody
    public Map<String, String> isLogin(HttpSession session,@RequestParam(value = "sessionId") String sessionID){
        HttpSession sess = session.getSessionContext().getSession(sessionID);
        Integer userId = (Integer)sess.getAttribute("userId");
        String userName = (String)sess.getAttribute("userName");
        String userCategory = (String)sess.getAttribute("userCategory");
        logger.info("userId:{},userName:{},userCategory:{}",userId,userName,userCategory);
        HashMap<String,String> map = new HashMap<>();
        map.put("userId",userId.toString());
        map.put("userName",userName);
        map.put("userCategory",userCategory);
        return map;
    }

    //用户上传
    @RequestMapping("/upload")
    public String Toupload(){
        return "upload.html";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/getuserById",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getUser(@RequestParam("userId") String userId){
        Integer Id = Integer.parseInt(userId);
        User user = userService.findById(Id);
        HashMap<String,String> map = new HashMap<>();
        map.put("userName",user.getUserName());
        map.put("userCategory",user.getUserCategory());
        return map;
    }


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getUserByName")
    @ResponseBody
    public User getUserByName(@RequestParam(value = "userName") String userName){
        logger.info("userName:{}",userName);
        return userService.findUserByUserName(userName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/delete")
    @ResponseBody
    public void deleteUser(Integer userId){
        logger.info("userId:{}",userId);
        userService.delete(userService.findById(userId));
    }
}





package main.java;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {

	private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);

	public static void main(String[] args) {
		log.info("My First Apache Shiro Application");

		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:main/resources/shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// get the currently executing user:
		Subject currentUser = SecurityUtils.getSubject();

		// Do some stuff with a Session (no need for a web or EJB container!!!)
		Session session = currentUser.getSession();
		session.setAttribute("someKey", "aValue");
		String value = (String) session.getAttribute("someKey");
		if (value.equals("aValue")) {
			log.info("\n\n--->Retrieved the correct value! [" + value + "]");
		}

		// let's login the current user so we can check against roles and permissions:
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken("helmet", "12345");
			token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				log.info("\n\n\nThere is no user with username of " + token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				log.info("\n\nPassword for account " + token.getPrincipal() + " was incorrect!");
			} catch (LockedAccountException lae) {
				log.info("\n\n\nThe account for username " + token.getPrincipal() + " is locked.  "
						+ "Please contact your administrator to unlock it.");
			}
			// ... catch more exceptions here (maybe custom ones specific to your
			// application?
			catch (AuthenticationException ae) {
				// unexpected condition? error?
			}
		}

		// say who they are:
		// print their identifying principal (in this case, a username):
		log.info("\n\n\n--->User [" + currentUser.getPrincipal() + "] logged in successfully.");

		// test a role:
		if (currentUser.hasRole("schwartz")) {
			log.info("\n\nMay the Schwartz be with you!");
		} else {
			log.info("\n\n\nHello, mere mortal.");
		}

		if (currentUser.hasRole("Trump")) {
			log.info("\n\nMay the Trump be with you!");
		} else {
			log.info("\n\n\nHello, mere mortal.");
		}

		if (currentUser.isPermitted("militaryPower")) {
			log.info("\n\nYou may have military power.  Use it wisely.");
		} else {
			log.info("\n\n\nSorry, military  power are for Trump masters only.");
		}

		// test a typed permission (not instance-level)
		if (currentUser.isPermitted("lightsaber:weild")) {
			log.info("\n\nYou may use a lightsaber ring.  Use it wisely.");
		} else {
			log.info("\n\n\nSorry, lightsaber rings are for schwartz masters only.");
		}

		// a (very powerful) Instance Level permission:
		if (currentUser.isPermitted("winnebago:drive:eagle5")) {
			log.info("\n\n\nYou are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  "
					+ "Here are the keys - have fun!");
		} else {
			log.info("\n\n\nSorry, you aren't allowed to drive the 'eagle5' winnebago!");
		}

		// all done - log out!
		currentUser.logout();

		System.exit(0);
	}
}
//package com.otp.project.OTPProject.services;
//
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.otp.project.OTPProject.dao.OTPRepository;
//import com.otp.project.OTPProject.entities.OTP;
//import com.otp.project.OTPProject.exception.ExceededAttemptsException;
//import com.otp.project.OTPProject.exception.InvalidEmailException;
//import com.otp.project.OTPProject.exception.InvalidInputException;
//import com.otp.project.OTPProject.exception.InvalidOTPException;
//
//
//@Service
//public class OTPServiceImpl implements OTPService {
//
//	@Value("${validTime}")
//	public int validTime;
//
//	@Value("${attemptsTimeout}")
//	public int attemptsTimeout;
//
//	@Autowired
//	private OTPRepository otpRepository;
//
//	@Autowired
//	public EmailService emailService;
//
//	public Integer generateOTP() {
//		return (int) ((Math.random() * 900000) + 100000);
//	}
//
//	public boolean checkEmail(String email) {
//		String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w{2,}([-.]\\w+)*$";
//		Pattern pattern = Pattern.compile(regex);
//		// Creating a Matcher object
//		Matcher matcher = pattern.matcher(email);
//		return matcher.matches();
//
//	}
//
//	@Override
//	public int sendOTP(OTP otpObj) throws InvalidInputException {
//
//		OTP objOtpp = new OTP();
//		int id = (int) ((Math.random() * 900) + 1000);
//		otpObj.setOrderId(id);
//		
//		Integer otp = generateOTP();
//		if (otp <= 99999) {
//			throw new InvalidOTPException("OTP is not valid");
//		}
//		if (otpObj.getChannelName() == null || otpObj.getEmail() == null) {
//			throw new InvalidInputException("channel name  or email can't be empty");
//		}
//
//		OTP objOtp = new OTP(otpObj.getOrderId(), otpObj.getEmail(), otpObj.getOtp(), false, otpObj.getChannelName());
//		//objOtp.setCreated_at(LocalDate.now());
//		objOtp.setOtp(otp);
//
//		if (checkEmail(otpObj.getEmail())) { //checking that email is valid or not
//
//			sendOTPMail(objOtp.getEmail(), objOtp.getOtp(), objOtp.getOrderId());
//
//			Timer timer = new Timer();
//			timer.schedule(new TimerTask() {
//				@Override
//				public void run() {
//					objOtp.setOtp(0);
//					otpRepository.save(objOtp);
//				}
//			}, validTime);
//
//			timer.schedule(new TimerTask() {
//				@Override
//				public void run() {
//					objOtp.setAttempts(0);
//					otpRepository.save(objOtp);
//				}
//			}, attemptsTimeout);
//
//			otpRepository.save(objOtp);
//			return otp;
//		} else {
//			throw new InvalidEmailException("Please enter valid email");
//		}
//
//	}
//
//	@Override
//	public String validateOTP(String channelName,String email,Integer orderId,int otp) throws ExceededAttemptsException {
//
//		OTP objOtp = otpRepository.findById(orderId).get();
//
//		
//		
//
//		if (objOtp.getAttempts() >= 5)
//			throw new ExceededAttemptsException("You exceed your limits");
//
//		objOtp.setAttempts(objOtp.getAttempts() + 1);
//		otpRepository.save(objOtp);
//
//		if (!channelName.equals(objOtp.getChannelName()))
//			return "Channel Name doesn't match please try again";
//		else if (objOtp.getOtp() == 0)
//			return "Timeout for this OTP! Try Again";
//		else if (otp != objOtp.getOtp())
//			return "Invalid OTP";
//		else {
//			objOtp.setAttempts(objOtp.getAttempts() - 1);
//			otpRepository.save(objOtp);
//			return "OTP Validated";
//		}
//
//	}
//
//	public void sendOTPMail(String email, int otp, int orderId) {
//		int order = (int) (Math.random() * 1000);
//		emailService.sendSimpleMessage(email, "OTP for email verification",
//				"Your orderId is:" + orderId + "\n otp is:" + otp);
//
//	}
//}

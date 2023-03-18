package com.synrgy.commit.util;

import org.springframework.stereotype.Component;

@Component("emailTemplate")
public class EmailTemplate {

    public String getResetPassword(){

        return "<!doctype html>\n" +
                "<html lang=\"en-US\">\n" +
                "<head>" +
               "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "<title>Reset Password Email Template</title>\n" +
                "<meta name=\"description\" content=\"Reset Password Email Template.\"> \n" +
                "<style type=\"text/css\"> \n" +
                "a:hover {text-decoration: underline !important;}\n" +
                "</style> \n" +
                "</head>\n" +
                "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">\n" +
                "<table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "<tr>\n" +
                "<td>\n" +
            	"<table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"" +
                "align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "<tr>\n" +
                "<td style=\"height:80px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"text-align:center;\">\n" +
                "<a href=\"#\" title=\"logo\" target=\"_blank\">\n" +
                "<img width=\"60\" src=\"https://drive.google.com/uc?export=view&id=1NiO5cQZDXA31eFJozu_wrEHUK4vbzz1o\" title=\"logo\" alt=\"logo\">\n" +
                "</a>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"height:20px;\">&nbsp;</td>\n"+
                "</tr>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"" +
                "style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "<tr>\n" +
                "<td style=\"height:40px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:0 35px;\">\n" +
                "<h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Hi {{USERNAME}}, you have requested verification code for your password.</h1>\n" +
                "<span " +
                "style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "<p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "Please use the verification code below to reset your password : <br/> </p>" +
                "<strong style=\"font-size:24px;\">{{PASS_TOKEN}}</strong> <br/>\n" +
                "<p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "If this action wasn’t done by you, please contact us on <b>tech.commitapp@gmail.com</b>. But if it’s you, you can ignore this message. </p>" +
                "</td>\n"+
                "</tr>\n"+
                "<tr>\n" +
                "<td style=\"height:40px;\">&nbsp;</td>" +
                "</tr>\n"+
                "</table>\n"+
                "</td>\n" +
                "<tr>\n" +
                "<td style=\"height:20px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr>\n"+
                "<td style=\"text-align:center;\">\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"height:80px;\">&nbsp;</td>\n"+
                "</tr>\n" +
            	"</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";
    }

    public String ApproveEmail() {
        return "<!doctype html>\n" +
                "                <html lang=\"en-US\">\n" +
                "                <head> \n" +
                "               <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "                <title>Reset Password Email Template</title>\n" +
                "                <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
                "                <style type=\"text/css\">  \n" +
                "                a:hover {text-decoration: underline !important;}\" \n" +
                "                </style>\n" +
                "                </head>\n" +
                "                <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "                \"style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|OpenSans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "            \t<table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
                "                \"align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                <a href=\"#\" title=\"logo\" target=\"_blank\">\n" +
                "                <img width=\"60\" src=\"https://drive.google.com/uc?export=view&id=1NiO5cQZDXA31eFJozu_wrEHUK4vbzz1o\" title=\"logo\" alt=\"logo\">\n" +
                "                </a>\n" +
                "                </td> \n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "                <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"padding:0 35px;\">\n" +
                "                <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Hey, {{USERNAME}} ! <br/>Your payment has been approved! </h1> <span style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "                  <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "                  Here is the detailed information :\n" +
                "                  </p>\n" +
                "                  <br/>\n" +
                "                  <table class=\"table\" style=\"width:100%; border: 1px solid #cecece;\">\n" +
                "                                        <thead>\n" +
                "                                        <tr>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\" >Transaction ID</th>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">{{TRANSACTION}}</th>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">Plan</th>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">{{PLAN}} Month</th>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                             <th style= \"border: 1px solid #cecece;\">Status</th>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">{{STATUS}}</th>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">Payment Method</th>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">{{PAYMENT}}</th>\n" +
                "                                        </tr>\n" +
                "                                          <tr>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">Total</th>\n" +
                "                                            <th style= \"border: 1px solid #cecece;\">{{TOTAL}}</th>\n" +
                "                                        </tr>\n" +
                "                                        </thead>\n" +
                "                                    </table>\n" +
                "                  <br/>\n" +
                "                <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "               Thank you for your payment! <br/>Enjoy your Premium Content in <b>Commit</b>.</p>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                </td>\n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                </td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "            \t</table>\n" +
                "                </html>\n";
    }

    public String RejectEmail(){
        return "<!doctype html>\n" +
                "                <html lang=\"en-US\">\n" +
                "                <head> \n" +
                "               <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "                <title>Reset Password Email Template</title>\n" +
                "                <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
                "                <style type=\"text/css\">  \n" +
                "                a:hover {text-decoration: underline !important;}\" \n" +
                "                </style>\n" +
                "                </head>\n" +
                "                <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "                \"style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|OpenSans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "            \t<table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
                "                \"align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                <a href=\"#\" title=\"logo\" target=\"_blank\">\n" +
                "                <img width=\"60\" src=\"https://drive.google.com/uc?export=view&id=1NiO5cQZDXA31eFJozu_wrEHUK4vbzz1o\" title=\"logo\" alt=\"logo\">\n" +
                "                </a>\n" +
                "                </td> \n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "                <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"padding:0 35px;\">\n" +
                "                <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Sorry {{USERNAME}}, your payment has been rejected </h1> <span style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "                <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "               Please try again and make sure to input the right transfer receipt before you make your order. If there’s any problem you can contact us on <b>tech.commitapp@gmail.com</b>.</p>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                </td>\n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                </td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "            \t</table>\n" +
                "                </html>\n";
    }

    public String Report(){
        return "<!doctype html>\n" +
                "                <html lang=\"en-US\">\n" +
                "                <head> \n" +
                "               <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "                <title>Reset Password Email Template</title>\n" +
                "                <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
                "                <style type=\"text/css\">  \n" +
                "                a:hover {text-decoration: underline !important;}\" \n" +
                "                </style>\n" +
                "                </head>\n" +
                "                <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "                \"style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|OpenSans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "            \t<table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
                "                \"align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                <a href=\"#\" title=\"logo\" target=\"_blank\">\n" +
                "                <img width=\"60\" src=\"https://drive.google.com/uc?export=view&id=1NiO5cQZDXA31eFJozu_wrEHUK4vbzz1o\" title=\"logo\" alt=\"logo\">\n" +
                "                </a>\n" +
                "                </td> \n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "                <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"padding:0 35px;\">\n" +
                "                <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Hey {{NAMA}}, thank you for your report ! </h1> <span style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "                <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "                We have received your report and we will immediately follow up on your report. <br/>\n" +
                "                Wait for a reply from us about 3x24 hours to notify you of the results you will receive.</p>\n"+
                "                </td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                </td>\n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                </td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "            \t</table>\n" +
                "                </html>\n";
    }

    public String verifyUser(){
        return "<!doctype html>\n" +
                "                <html lang=\"en-US\">\n" +
                "                <head> \n" +
                "               <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "                <title>Reset Password Email Template</title>\n" +
                "                <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
                "                <style type=\"text/css\">  \n" +
                "                a:hover {text-decoration: underline !important;}\" \n" +
                "                </style>\n" +
                "                </head>\n" +
                "                <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "                \"style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|OpenSans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "            \t<table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
                "                \"align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                <a href=\"#\" title=\"logo\" target=\"_blank\">\n" +
                "                <img width=\"60\" src=\"https://drive.google.com/uc?export=view&id=1NiO5cQZDXA31eFJozu_wrEHUK4vbzz1o\" title=\"logo\" alt=\"logo\">\n" +
                "                </a>\n" +
                "                </td> \n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td> \n" +
                "                <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "                <tr>\n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"padding:0 35px;\">\n" +
                "                <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Congratulation {{USERNAME}}, your account has been verified !</h1> <span style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "<p style=\"color: #455056; font-size: 15px; line-height: 24px; margin: 0; text-align:left;\">Thank you for your submission, we have processed your account to be verified. With verified account it means that we acknowledged the quality of your contents and will ask you directly to participate on our Simpler feature !</p><br/>\n" +
                "<p style=\"color: #455056; font-size: 15px; line-height: 24px; margin: 0; text-align:left;\">Simpler is a premium menu for subscribers only. It provide premium contents made by Commit and Verified Users. For Simpler benefits, these are few things you have to know :</p>\n" +
                "<ol style=\"color: #455056; font-size: 15px; line-height: 24px; margin: 0; text-align:left;\">\n" +
                "<li>You will get paid for each post you&rsquo;ve made, monthly. We will be transfer the revenue to the bank account you&rsquo;ve given on your submission</li>\n" +
                "<li>If you haven&rsquo;t created any post in a month then we will not pay you.</li>\n" +
                "<li>Any verified users has the access to Simpler for Free.</li>\n" +
                "</ol>\n" +
                "<p style=\"color: #455056; font-size: 15px; line-height: 24px; margin: 0; text-align:left;\">\n" +
                "  No need to feel obligated for posting premium contents on Simpler ! <br/><br/> Once again thank you for joining our community,\n" +
                "If there’s any problem you can contact us on <b>tech.commitapp@gmail.com</b>.\n" +
                "</p>\n"+
                "                </td>\n" +
                "                </tr>\n" +
                "                <tr> \n" +
                "                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                </td>\n" +
                "                <tr> \n" +
                "                <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                <td style=\"text-align:center;\">\n" +
                "                </td>\n" +
                "                </tr> \n" +
                "                <tr> \n" +
                "                <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "            \t</table>\n" +
                "                </html>\n";
    }

}



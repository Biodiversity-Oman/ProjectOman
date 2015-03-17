<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<!DOCTYPE html>
<html>
        <body>
        <script>
           function enableInput(){
               if (document.getElementById("update").type === "submit") {
                    document.getElementById("update").type = "button";
                    document.getElementById("update").value = "Update";
                    document.getElementById("firstname").disabled = false;
                    document.getElementById("lastname").disabled = false;
                    document.getElementById("city").disabled = false;
                    document.getElementById("country").disabled = false;
                    document.getElementById("phone").disabled = false;
                    document.getElementById("email").disabled = false;
                } else if (document.getElementById("update").type === "button") {
                    document.getElementById("update").type = "submit";
                }
            };
            function disableInput() {
                        document.getElementById("firstname").disabled = true;
                        document.getElementById("lastname").disabled = true;
                        document.getElementById("city").disabled = true;
                        document.getElementById("country").disabled = true;
                        document.getElementById("email").disabled = true;
                        document.getElementById("phone").disabled = true;
            };
            function loadUserInfo() {
                $.ajax({
                    url: 'GetUserAccount?user=<%=username%>',
                    type: 'GET',
                    dataType: 'json',
                    cache: false,
                    async: true,
                }).done(function (data) {
                    $('#firstname').val(data.firstName);
                    $('#lastname').val(data.lastName);
                    $('#city').val(data.city);
                    $('#country').val(data.country);
                    $('#phone').val(data.phone);
                    $('#email').val(data.email);
                    $('#isadmin').val(data.isAdmin);
                });
            };
            $(document).ready(function (){
                loadUserInfo();
            });
        </script>
                <div class="wrapper">
                        <h1 class="field-title">User Information:</h1>
                        <div class="user-box">
                                <form role="form" id="update-user-form" class="form-horizontal">
                                        <input type="hidden" value="<%=username%>" name="username">
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="username">Username</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="username" type="text" value="<%=username%>" disabled >
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="firstname">Firstname</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="firstname" name="firstname" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" disabled required >
                                                        <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="lastname">Lastname</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="lastname" name="lastname" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" disabled required >
                                                        <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="city">City</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="city" name="city" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" disabled required >
                                                        <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="country">Country</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="country" name="country" pattern="[^()[\]{}*&^%$=~+<>#0-9@!]+$" disabled required >
                                                        <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits and special symbols)</span>
                                                </div>
                                        </div>
                                        <div class="form-group" >
                                                <label class="col-sm-2 control-label"  for="phone">Phone</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" id="phone" name="phone" pattern="^[0-9./()-]+$" disabled required >
                                                        <span class="help-block with-errors">Up to 20 digits between 0-9 and symbols "- / . ()"</span>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label" for="email">E-mail</label>
                                                <div class="col-sm-6">
                                                        <input class="form-control" type="email" id="email" pattern="\b[A-Z0-9._+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,4}\b$)" name="email" disabled required >
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label"></label>
                                                <div class="col-sm-6">
                                                        <div id="update-user-message"></div>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <label class="col-sm-2 control-label"></label>
                                                <div class="col-sm-6">
                                                        <input class="button-grey" id="update" type="submit" value="Edit" onClick="enableInput()" />
                                                </div>
                                        </div>
                                </form>
                                <div id="fade" class="black_overlay-boxed"></div>
                                <div id="fade2" class="black_overlay-boxed"></div>
                                <div class="form-group">
                                        <label class="col-sm-2 control-label"></label>
                                        <a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'block';
                            document.getElementById('fade2').style.display = 'block'"><button style="margin-left: 0.3em;" class="button-grey"><span class="icon-cross-button"></span>Delete Account</button></a>
                                        <div id="delete" class="whiteboxdialog"><a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                            document.getElementById('fade2').style.display = 'none'"><label class="close-button">x</label></a>
                                                <div class="content">
                                                        <p>Are you sure you want to delete your account?</p><br>
                                                        <a href="DeleteUserAccount?username=<%=username%>"><input class="button-grey" type="button" value="Yes" /></a>
                                                        <a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                                    document.getElementById('fade2').style.display = 'none'"><button class="button-grey">No</button></a>
                                                </div>
                                        </div>
                                        <a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'block';
                            document.getElementById('fade').style.display = 'block'"><button class="button-grey"><span class="icon-pencil2-button"></span>Change Password</button></a>
                                        <div id="changepassword" class="whitebox"><a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'none';
                            document.getElementById('fade').style.display = 'none'"><label class="close-button">x</label></a>
                                                <div class="content">
                                                        <form role="form" class="form-horizontal" id="change-password-form" data-toggle="validator">
                                                                <input type="hidden" value="<%=username%>" name="username">
                                                                <div class="form-group">
                                                                        <label class="col-sm-4 control-label">Old password</label>
                                                                        <div class="col-sm-6">
                                                                                <input class="form-control" name="oldpassword"  type="password" data-delay="1200" required>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group">
                                                                        <label class="col-sm-4 control-label" for="newpassword">New password</label>
                                                                        <div class="col-sm-6">
                                                                                <input class="form-control" id="inputPassword" type="password" name="newpassword" data-delay="1200" data-minlength="6" maxlength="15" required>
                                                                                <span class="help-block">Minimum of 6 characters maximum 15 characters</span>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group">
                                                                        <label class="col-sm-4 control-label" for="comfirmnewpassword">Comfirm new password</label>
                                                                        <div class="col-sm-6">
                                                                                <input class="form-control" type="password" name="check" data-delay="1200" data-match="#inputPassword" data-minlength="6" maxlength="15" required>
                                                                                <div class="help-block with-errors"></div>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group">
                                                                        <label class="col-sm-4 control-label"></label>
                                                                        <div class="col-sm-6">
                                                                                <div id="update-password-message"></div>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group">
                                                                        <label class="col-sm-4 control-label"></label>
                                                                        <div class="col-lg-8">
                                                                                <a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'block';
                                                document.getElementById('fade').style.display = 'block'"><input id="wijzig" class="button-grey" type="submit" value="Change" ></a>
                                                                                <a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'none';
                                                document.getElementById('fade').style.display = 'none'"><input class="button-grey" type="reset" value="Cancel" ></a>
                                                                        </div>
                                                                </div>
                                                        </form>
                                                </div>
                                        </div>
                                </div>
                        </div>
                </div>
        </body>
</html>

(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-11ced923"],{"4b4f":function(e,s,a){"use strict";var t=a("cd05"),r=a.n(t);r.a},"51d7":function(e,s,a){"use strict";var t=a("ea78"),r=a.n(t);r.a},"6c04":function(e,s,a){"use strict";var t=a("ac31"),r=a.n(t);r.a},a31d:function(e,s,a){e.exports=a.p+"img/sysName.e56b8826.png"},ac31:function(e,s,a){},cd05:function(e,s,a){},e49c:function(e,s,a){"use strict";a.r(s);var t=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",{staticClass:"login",class:{"login-no-logo":!e.$store.state.app.showFirmLogo}},[t("img",{staticClass:"sysName",attrs:{src:a("a31d")}}),t("div",{staticClass:"cover"}),t("div",{staticClass:"login-con"},[t("Card",{attrs:{icon:"log-in",title:"欢迎登录",bordered:!1}},[t("div",{staticClass:"form-con"},[t("login-form",{on:{"on-success-valid":e.handleSubmit}})],1)])],1)])},r=[],o=function(){var e=this,s=e.$createElement,a=e._self._c||s;return a("Form",{ref:"loginForm",attrs:{model:e.form,rules:e.rules},nativeOn:{keydown:function(s){return"button"in s||!e._k(s.keyCode,"enter",13,s.key,"Enter")?e.handleSubmit(s):null}}},[a("FormItem",{attrs:{prop:"userName"}},[a("Input",{attrs:{placeholder:"请输入用户名"},model:{value:e.form.userName,callback:function(s){e.$set(e.form,"userName",s)},expression:"form.userName"}},[a("span",{attrs:{slot:"prepend"},slot:"prepend"},[a("Icon",{attrs:{size:16,type:"ios-person"}})],1)])],1),a("FormItem",{attrs:{prop:"password"}},[a("Input",{attrs:{type:"password",placeholder:"请输入密码"},model:{value:e.form.password,callback:function(s){e.$set(e.form,"password",s)},expression:"form.password"}},[a("span",{attrs:{slot:"prepend"},slot:"prepend"},[a("Icon",{attrs:{size:14,type:"md-lock"}})],1)])],1),a("FormItem",[a("div",{staticClass:"remberPass"},[a("Checkbox",{model:{value:e.isremember,callback:function(s){e.isremember=s},expression:"isremember"}},[e._v("记住密码")])],1),a("Button",{attrs:{type:"primary",long:""},on:{click:e.handleSubmit}},[e._v("登录")])],1)],1)},n=[],i=a("b4c3"),u={name:"LoginForm",props:{userNameRules:{type:Array,default:function(){return[{required:!0,message:"账号不能为空",trigger:"blur"}]}},passwordRules:{type:Array,default:function(){return[{required:!0,message:"密码不能为空",trigger:"blur"}]}}},data:function(){return{form:{userName:"",password:""},isremember:!1}},mounted:function(){this.getPassword()},computed:{rules:function(){return{userName:this.userNameRules,password:this.passwordRules}}},methods:{getPassword:function(){var e=i["a"].fetch("isremember"),s=i["a"].fetch("username"),a=i["a"].fetch("password");e&&a&&s&&(this.form.password=a,this.form.userName=s,this.isremember=!0)},handleSubmit:function(){var e=this;this.$refs.loginForm.validate(function(s){s&&e.$emit("on-success-valid",{username:e.form.userName,password:e.form.password,isremember:e.isremember})})}}},m=u,c=(a("51d7"),a("2877")),l=Object(c["a"])(m,o,n,!1,null,null,null);l.options.__file="login-form.vue";var d=l.exports,p=d,f=a("66df"),v=a("2938"),b=v["a"]+"api/",h=function(e){return f["a"].request({url:b+"account/login",method:"post",data:e})},g={components:{LoginForm:p},mounted:function(){},methods:{handleSubmit:function(e){var s=this,a=e.username,t=e.password,r=e.isremember,o=i["a"].fetchSession("accountType");h({username:a,password:t,accountType:o}).then(function(e){i["a"].saveSession("loginType",!0),i["a"].save("username",a),i["a"].save("password",t),i["a"].saveSession("username",a),i["a"].saveSession("password",t),i["a"].saveSession("editName",e.data.data.editName),i["a"].saveSession("company",e.data.data.company),i["a"].saveSession("companyNum",e.data.data.companyNum),i["a"].saveSession("editTel",e.data.data.editTel),i["a"].saveSession("accountType",e.data.data.accountType),r?i["a"].save("isremember",!0):i["a"].save("isremember",!1),i["a"].save("tagNaveList",[]),s.$router.push({name:"home"})}).catch(function(e){})}}},w=g,y=(a("4b4f"),a("6c04"),Object(c["a"])(w,t,r,!1,null,null,null));y.options.__file="login.vue";s["default"]=y.exports},ea78:function(e,s,a){}}]);
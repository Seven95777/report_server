(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-01f5a8b3"],{2852:function(t,a,n){"use strict";var e=n("532b"),o=n.n(e);o.a},3781:function(t,a,n){"use strict";var e=n("eb14"),o=n.n(e);o.a},"532b":function(t,a,n){},9393:function(t,a,n){"use strict";function e(t){if(Array.isArray(t))return t}function o(t,a){var n=[],e=!0,o=!1,s=void 0;try{for(var i,c=t[Symbol.iterator]();!(e=(i=c.next()).done);e=!0)if(n.push(i.value),a&&n.length===a)break}catch(t){o=!0,s=t}finally{try{e||null==c["return"]||c["return"]()}finally{if(o)throw s}}return n}function s(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}function i(t,a){return e(t)||o(t,a)||s()}n.d(a,"a",function(){return i})},"94f9":function(t,a,n){"use strict";n.d(a,"a",function(){return i}),n.d(a,"b",function(){return c});var e=n("66df"),o=n("2938"),s=o["a"]+"api/base/",i=function(t){return e["a"].request({url:s+"add",method:"post",data:t})},c=function(t){return e["a"].request({url:s+"list",method:"post",data:t})}},c576:function(t,a,n){"use strict";n.r(a);var e=function(){var t=this,a=t.$createElement,n=t._self._c||a;return n("div",{staticClass:"home",attrs:{id:"systemLog"}},[n("Card",{staticClass:"margin-top10"},[n("Form",{ref:"systemLogForm",attrs:{inline:"","label-position":"right","label-width":80,model:t.filtData}},[n("Form-item",{attrs:{label:"手机号："}},[n("Input",{attrs:{type:"text",placeholder:"请输入手机尾号后4位数",clearable:""},model:{value:t.filtData.tel,callback:function(a){t.$set(t.filtData,"tel",a)},expression:"filtData.tel"}})],1),n("Form-item",{staticClass:"btn-form-item"},[n("Button",{attrs:{type:"info",icon:"md-search"},on:{click:t.query}},[t._v("查询")])],1),n("Form-item",{staticClass:"float-right"},[n("Button",{attrs:{type:"info",loading:t.btnLoading},on:{click:t.submit}},[t._v("提交")])],1)],1),n("hot-table",{ref:"hott",attrs:{settings:t.hotSettings,licenseKey:"non-commercial-and-evaluation"}})],1)],1)},o=[],s=(n("6b54"),n("7f7f"),n("9393")),i=(n("ac6a"),n("cadf"),n("551c"),n("097d"),n("b4c3")),c=n("3292"),r=n("3c78"),l=(n("250e"),n("c1df")),u=n.n(l),d=n("66df"),f=n("2938"),m=f["a"]+"api/guest/",h=function(t){return d["a"].request({url:m+"add",method:"post",data:t})},p=function(t){return d["a"].request({url:m+"list",method:"post",data:t})},b=n("94f9"),y={name:"Visitor",data:function(){var t=this;return{btnLoading:!1,hotSettings:{className:"htCenter htMiddle",minSpareRows:1,headerTooltips:{rows:!1,columns:!0,onlyTrimmed:!0},fixedRowsTop:0,data:[],width:"100%",height:"600",stretchH:"all",colWidths:100,rowHeaders:!0,colHeaders:["姓名","身份证号码","手机号码","公司名称","目前居住地","14天内有无湖北等疫情高发地旅居历史","14天内有无与确诊病例、疑似病例接触史","本人及家人有无发热、干咳等疑似症状","体温","来访日期"],columns:[{data:"name"},{data:"idCard"},{data:"tel"},{data:"company"},{data:"address"},{data:"contactHb",editor:"select",selectOptions:["无","有"]},{data:"contact",editor:"select",selectOptions:["无","有"]},{data:"familyHealth",editor:"select",selectOptions:["无","有"]},{data:"temp",editor:"select",selectOptions:["正常","异常"]},{data:"visitTime"}],language:"zh-CN",contextMenu:c["a"].contextOption,beforeChange:function(t){},afterOnCellMouseDown:function(a,n,e){n.row>-1&&9===n.col&&t.$refs.hott.hotInstance.setDataAtCell(n.row,n.col,u()().format("YYYY-MM-DD HH:mm:ss"))},afterChange:function(a){a&&a.forEach(function(a){var n=Object(s["a"])(a,4),e=n[0],o=n[1],r=n[2],l=n[3];"tel"===o&&r!=l&&l?Object(b["b"])({tel:l,personType:1,companyNum:i["a"].fetchSession("companyNum"),subFlag:0}).then(function(a){var n=a.data.data;n.length>0&&(t.list[e].idCard=n[0].idCard,t.list[e].name=n[0].name,t.list[e].company=n[0].company,t.list[e].address=n[0].address,t.list[e].contact=c["a"].constants.CONTACT[n[0].contact],t.list[e].contactHb=c["a"].constants.CONTACTHB[n[0].contactHb],t.list[e].familyHealth=c["a"].constants.FAMILYHEALTH[n[0].familyHealth],t.list[e].temp="正常",t.$refs.hott.hotInstance.loadData(t.list))}):"visitTime"!==o&&t.$refs.hott.hotInstance.setDataAtCell(e,9,u()().format("YYYY-MM-DD HH:mm:ss"))})}},list:[],filtData:{tel:null},queryData:{name:null,tel:null,idCard:null,subFlag:0}}},components:{HotTable:r["a"]},created:function(){},methods:{query:function(){var t=this,a=[];a=this.filtData.tel?this.$refs.hott.hotInstance.getSourceData().filter(function(a){return a.tel&&a.tel.toString().substr(-4)==t.filtData.tel}):this.list,this.$refs.hott.hotInstance.loadData(a)},submit:function(){var t=this,a=this.list,n=[];n=a.map(function(t){var a={};for(var n in t)a[n]=t[n];return a}).filter(function(a){a["temp"]=c["a"].constants.TEMP[a["temp"]],a["contactHb"]=c["a"].constants.CONTACTHB[a["contactHb"]],a["contact"]=c["a"].constants.CONTACT[a["contact"]],a["familyHealth"]=c["a"].constants.FAMILYHEALTH[a["familyHealth"]];var n=!1;return t.hotSettings.columns.forEach(function(t){null!==a[t.data]&&void 0!==a[t.data]&&""!==a[t.data]&&(n=!0)}),n}).map(function(t){return t["companyNum"]=i["a"].fetchSession("companyNum"),t}),this.btnLoading=!0,0===n.length&&(n=[{delNum:1,companyNum:i["a"].fetchSession("companyNum")}]),h(n).then(function(a){t.btnLoading=!1,0===a.data.code&&t.$Message.success("操作成功！")}).catch(function(){t.btnLoading=!1})},_getList:function(){var t=this,a=i["a"].fetchSession("companyNum"),n=this.queryData,e=n.name,o=n.tel,s=n.idCard,r=n.subFlag;p({name:e,tel:o,idCard:s,subFlag:r,companyNum:a}).then(function(a){var n=a.data.data;t.list=n.map(function(t){return t["temp"]=c["a"].constants.TEMP[t["temp"]],t["contactHb"]=c["a"].constants.CONTACTHB[t["contactHb"]],t["contact"]=c["a"].constants.CONTACT[t["contact"]],t["familyHealth"]=c["a"].constants.FAMILYHEALTH[t["familyHealth"]],t}),t.$nextTick(function(){t.$refs.hott.hotInstance.loadData(t.list)})}).catch(function(t){console.log(t)})}},mounted:function(){this._getList()}},g=y,H=(n("3781"),n("2852"),n("2877")),v=Object(H["a"])(g,e,o,!1,null,null,null);v.options.__file="visitor.vue";a["default"]=v.exports},eb14:function(t,a,n){}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5cf182ed"],{3651:function(t,a,e){"use strict";var n=e("bb78"),o=e.n(n);o.a},"3ff8":function(t,a,e){},9393:function(t,a,e){"use strict";function n(t){if(Array.isArray(t))return t}function o(t,a){var e=[],n=!0,o=!1,r=void 0;try{for(var s,c=t[Symbol.iterator]();!(n=(s=c.next()).done);n=!0)if(e.push(s.value),a&&e.length===a)break}catch(t){o=!0,r=t}finally{try{n||null==c["return"]||c["return"]()}finally{if(o)throw r}}return e}function r(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}function s(t,a){return n(t)||o(t,a)||r()}e.d(a,"a",function(){return s})},"94f9":function(t,a,e){"use strict";e.d(a,"a",function(){return s}),e.d(a,"b",function(){return c});var n=e("66df"),o=e("2938"),r=o["a"]+"api/base/",s=function(t){return n["a"].request({url:r+"add",method:"post",data:t})},c=function(t){return n["a"].request({url:r+"list",method:"post",data:t})}},"9bc7":function(t,a,e){"use strict";e.r(a);var n=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{attrs:{id:"systemLog"}},[e("Card",{staticClass:"margin-top10"},[e("Form",{ref:"systemLogForm",attrs:{"label-position":"right","label-width":80,model:t.queryData,inline:""}},[e("FormItem",{attrs:{prop:"user",label:"手机号"}},[e("Input",{attrs:{type:"text",placeholder:"请输入手机尾号后4位数",clearable:""},model:{value:t.queryData.tel,callback:function(a){t.$set(t.queryData,"tel",a)},expression:"queryData.tel"}})],1),e("FormItem",{staticClass:"btn-form-item"},[e("Button",{attrs:{type:"info"},on:{click:t.query}},[t._v("查询")])],1),e("FormItem",{staticClass:"float-right"},[e("Button",{attrs:{type:"info",loading:t.loading},on:{click:t.submit}},[t._v("提交")])],1)],1),e("hot-table",{ref:"hott",attrs:{settings:t.hotSettings,licenseKey:"non-commercial-and-evaluation"}})],1)],1)},o=[],r=e("c93e"),s=(e("456d"),e("7f7f"),e("9393")),c=(e("ac6a"),e("cadf"),e("551c"),e("097d"),e("3292")),i=e("3c78"),l=(e("1699"),e("250e"),e("c276")),d=(e("c1df"),e("b4c3")),u=e("66df"),m=e("2938"),f=m["a"]+"api/project/",h=function(t){return u["a"].request({url:f+"add",method:"post",data:t})},p=function(t){return u["a"].request({url:f+"list",method:"post",data:t})},g=e("94f9"),y={name:"Visitor",data:function(){var t=this;return{loading:!1,hotSettings:{className:"htCenter htMiddle",minSpareRows:1,headerTooltips:{rows:!1,columns:!0,onlyTrimmed:!0},fixedRowsTop:0,data:[],width:"100%",height:"600",stretchH:"all",colWidths:120,rowHeights:50,rowHeaders:!0,search:!0,language:"zh-CN",contextMenu:c["a"].contextOption,colHeaders:["人员姓名","手机号码","身份证号","所属单位","目前居住地","项目名称","是否为重点项目","近14天有无接触疫区人员","近14天是否出现症状或被隔离","目前体温及健康状况","来源地"],columns:[{data:"name"},{data:"tel"},{data:"idCard"},{data:"company"},{data:"address"},{data:"projectName"},{data:"imptFlag",editor:"select",selectOptions:["是","否"]},{data:"contact",editor:"select",selectOptions:["有","无"]},{data:"contactHb",editor:"select",selectOptions:["有","无"]},{data:"temp",editor:"select",selectOptions:["正常","异常"]},{data:"fromAddr"}],afterChange:function(a,e){a&&a.forEach(function(a){var e=Object(s["a"])(a,4),n=e[0],o=e[1],r=e[2],i=e[3];if("tel"===o&&r!=i){if(!i)return;Object(g["b"])({tel:i}).then(function(a){var e=a.data;if(t.list&&0!==t.list.length&&e.data&&0!==e.data.length){var o=e.data[0],r=o.companyNum?o.companyNum:1,s=o.name?o.name:"",i=o.tel?o.tel:"",l=o.idCard?o.idCard:"",d=o.company?o.company:"",u=o.address?o.address:"",m=o.projectName?o.projectName:"",f=o.fromAddr?o.fromAddr:"",h="",p="",g="",y="";h=o.imptFlag?c["a"].constants.IMPTFLAG[o.imptFlag]:c["a"].constants.IMPTFLAG["0"],p=o.contact?c["a"].constants.CONTACT[o.contact]:c["a"].constants.CONTACT["0"],g=o.contactHb?c["a"].constants.CONTACTHB[o.contactHb]:c["a"].constants.CONTACTHB["0"],y=o.temp?c["a"].constants.TEMP[o.temp]:c["a"].constants.TEMP["0"],t.list[n].companyNum=r,t.list[n].name=s,t.list[n].tel=i,t.list[n].idCard=l,t.list[n].company=d,t.list[n].address=u,t.list[n].projectName=m,t.list[n].fromAddr=f,t.list[n].imptFlag=h,t.list[n].contact=p,t.list[n].contactHb=g,t.list[n].temp=y,t.$refs.hott.hotInstance.loadData(t.list)}})}})}},list:[],companyNum:"",queryData:{tel:null}}},components:{HotTable:i["a"]},created:function(){this.companyNum=d["a"].fetchSession("companyNum")},mounted:function(){this._getTableData()},methods:{_getTableData:function(){var t=this,a={companyNum:this.companyNum,subFlag:0};p(a).then(function(a){var e=a.data,n=e.code,o=e.data;n===c["a"].statusCode.SUCCESS&&o&&0!==o.length?(t.list=o.map(function(a){return t._normalize(a)}),t.$refs.hott.hotInstance.loadData(t.list)):t.$refs.hott.hotInstance.loadData(t.list)}).catch(function(){t.$refs.hott.hotInstance.loadData(t.list)})},_normalize:function(t){if(!t||0!==Object.keys(t).length){for(var a in t)"imptFlag"===a&&(t[a]=c["a"].constants.IMPTFLAG[t[a]]),"contact"===a&&(t[a]=c["a"].constants.CONTACT[t[a]]),"contactHb"===a&&(t[a]=c["a"].constants.CONTACTHB[t[a]]),"temp"===a&&(t[a]=c["a"].constants.TEMP[t[a]]);return t}},_normalizeWrap:function(t){for(var a=this,e=[],n=t.filter(function(t){if(t&&0!==Object.keys(t).length)return t}),o=0;o<n.length;o++){var s=!1;for(var i in n[o])n[o][i]&&""!=n[o][i]&&(s=!0);s||n.splice(o,1)}for(var l=0;l<n.length;l++){var d=n[l];e.push({name:d.name?d.name:"",tel:d.tel?d.tel:"",company:d.company?d.company:"",idCard:d.idCard?d.idCard:"",address:d.address?d.address:"",projectName:d.projectName?d.projectName:"",fromAddr:d.fromAddr?d.fromAddr:"",imptFlag:d.imptFlag?c["a"].constants.IMPTFLAG[d["imptFlag"]]:0,contact:d.contact?c["a"].constants.CONTACT[d["contact"]]:0,contactHb:d.contactHb?c["a"].constants.CONTACTHB[d["contactHb"]]:0,temp:d.temp?c["a"].constants.TEMP[d["temp"]]:0})}var u=e.map(function(t){return Object(r["a"])({},t,{companyNum:a.companyNum,entryTime:(new Date).getTime()})});return u},query:function(){var t=this;this.$refs.hott.hotInstance.loadData(this.list);var a=[];a=this.queryData.tel?this.$refs.hott.hotInstance.getSourceData().filter(function(a){if(a.tel){var e=a.tel+"";return e.substr(-4)==t.queryData.tel}}):this.list,this.$refs.hott.hotInstance.loadData(a)},submit:function(){var t=this;this.loading=!0;var a=Object(l["a"])(this.$refs.hott.hotInstance.getSourceData()),e=this._normalizeWrap(a);if(e&&0===e.length)return this.$Modal.confirm({title:"是否保存此次操作？",onOk:function(){var a=[{companyNum:t.companyNum,delNum:t.companyNum}];h(a).then(function(a){t.loading=!1;var e=a.data,n=(e.code,e.resultMsg);t.$Message.success(n)}).catch(function(){t.loading=!1})},onCancel:function(){t.loading=!1}});h(e).then(function(a){t.loading=!1;var e=a.data,n=e.code,o=e.resultMsg;n===c["a"].statusCode.SUCCESS?(t.$Message.success("保存成功"),t._getTableData()):t.$Message.error(o)}).catch(function(){t.loading=!1})}}},b=y,v=(e("b80a"),e("3651"),e("2877")),C=Object(v["a"])(b,n,o,!1,null,null,null);C.options.__file="management.vue";a["default"]=C.exports},b80a:function(t,a,e){"use strict";var n=e("3ff8"),o=e.n(n);o.a},bb78:function(t,a,e){}}]);
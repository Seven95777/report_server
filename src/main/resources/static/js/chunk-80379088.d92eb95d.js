(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-80379088"],{43608:function(t,a,n){"use strict";n.r(a);var e=function(){var t=this,a=t.$createElement,n=t._self._c||a;return n("div",{attrs:{id:"systemLog"}},[n("Card",{staticClass:"margin-top10"},[n("Form",{ref:"systemLogForm",attrs:{"label-position":"right","label-width":80,inline:""}},[n("FormItem",{staticClass:"float-right"},[n("Button",{attrs:{type:"info",loading:t.loading},on:{click:t.submit}},[t._v("提交")])],1)],1),n("hot-table",{ref:"hott",attrs:{settings:t.hotSettings,licenseKey:"non-commercial-and-evaluation"}})],1)],1)},o=[],s=n("c93e"),i=(n("456d"),n("c5f6"),n("7f7f"),n("9393")),c=(n("ac6a"),n("cadf"),n("551c"),n("097d"),n("3292")),r=n("3c78"),l=(n("1699"),n("250e"),n("c276")),d=n("c1df"),u=n.n(d),m=n("94f9"),f=n("b4c3"),h=(n("534e"),{name:"personnel",data:function(){var t=this;return{loading:!1,list:[],companyNum:"",hotSettings:{className:"htCenter htMiddle",minSpareRows:1,headerTooltips:{rows:!1,columns:!0,onlyTrimmed:!0},fixedRowsTop:0,data:[],width:"100%",height:"600",stretchH:"all",rowHeights:50,rowHeaders:!0,search:!0,language:"zh-CN",contextMenu:c["a"].contextOption,colHeaders:["姓名","身份证","手机号","目前居住地","公司名称","14天有无接触","14天有无关联湖北等高发地","家人情况","体温","到访日期","时间"],columns:[{data:"name"},{data:"idCard"},{data:"tel"},{data:"address"},{data:"company"},{data:"contact",editor:"select",selectOptions:["有","无"]},{data:"contactHb",editor:"select",selectOptions:["有","无"]},{data:"familyHeath",editor:"select",selectOptions:["正常","异常"]},{data:"temp",editor:"select",selectOptions:["正常","异常"]},{data:"vistorDate"},{data:"time"}],afterChange:function(a){a&&a.forEach(function(a){var n=Object(i["a"])(a,4),e=n[0],o=n[1],s=n[2],r=n[3];if("tel"===o&&s!=r){if(!r)return;Object(m["b"])({tel:r}).then(function(a){var n=a.data;if(t.list&&0!==t.list.length&&n.data&&0!==n.data.length){var o=n.data[0],s="",i="",r="",l="";s=o.contact?c["a"].constants.CONTACT[o.contact]:c["a"].constants.CONTACT["0"],i=o.contactHb?c["a"].constants.CONTACTHB[o.contactHb]:c["a"].constants.CONTACTHB["0"],r=o.familyHeath?c["a"].constants.TEMP[o.familyHeath]:c["a"].constants.TEMP["0"],l=o.temp?c["a"].constants.TEMP[o.temp]:c["a"].constants.TEMP["0"],t.list[e]["name"]=o.name,t.list[e]["idCard"]=o.idCard,t.list[e]["address"]=o.address,t.list[e]["company"]=o.company,t.list[e]["contact"]=s,t.list[e]["contactHb"]=i,t.list[e]["familyHeath"]=r,t.list[e]["temp"]=l}t.list[e]["vistorDate"]=u()().format("YYYY-MM-DD HH:mm"),t.list[e]["time"]=u()().format("YYYY-MM-DD HH:mm"),t.$refs.hott.hotInstance.loadData(t.list)})}else t.list[e]["vistorDate"]=u()().format("YYYY-MM-DD HH:mm"),t.list[e]["time"]=u()().format("YYYY-MM-DD HH:mm"),t.$refs.hott.hotInstance.loadData(t.list)})}}}},components:{HotTable:r["a"]},created:function(){this.companyNum=Number(f["a"].fetchSession("companyNum"))},mounted:function(){this._getTableData()},methods:{_getTableData:function(){var t=this,a=(this.companyNum,[{name:"张超彦",idCard:"510104199003071683",tel:"13645990767",address:"崇州",company:"四川友邦家私有限责任公司",contact:"无",contactHb:"无",familyHeath:"正常",temp:"正常",vistorDate:"2020-2-29 11:00",time:"2020-2-29 11:00"},{name:"李式梅",idCard:"510104199003073865",tel:"17627638798",address:"成都",company:"四川好又多食品安全有限公司",contact:"无",contactHb:"无",familyHeath:"正常",temp:"正常",vistorDate:"2020-3-1 10:30",time:"2020-3-1 10:30"}]);this.list=a,this.$nextTick(function(){t.$refs.hott.hotInstance.loadData(t.list)})},_normalize:function(t){if(!t||0!==Object.keys(t).length){for(var a in t)"contact"===a&&(t[a]=c["a"].constants.CONTACT[t[a]]),"contactHb"===a&&(t[a]=c["a"].constants.CONTACTHB[t[a]]),"temp"!==a&&"familyHeath"!==a||(t[a]=c["a"].constants.TEMP[t[a]]);return t}},_normalizeWrapper:function(t){for(var a=this,n=[],e=t.filter(function(t){if(t&&0!==Object.keys(t).length)return t}),o=0;o<e.length;o++){var i=!1;for(var r in e[o])e[o][r]&&""!=e[o][r]&&(i=!0);i||e.splice(o,1)}e.map(function(t){n.push({name:t.name||"",idCard:t.idCard||"",tel:t.tel||"",address:t.address||"",company:t.company||"",contact:t.contact?c["a"].constants.CONTACT[t["contact"]]:0,contactHb:t.contactHb?c["a"].constants.CONTACTHB[t["contactHb"]]:0,familyHeath:t.contactHb?c["a"].constants.TEMP[t["familyHeath"]]:0,temp:t.temp?c["a"].constants.TEMP[t["temp"]]:0,vistorDate:t.vistorDate||"",time:t.time||""})});var l=n.map(function(t){return Object(s["a"])({},t,{companyNum:a.companyNum,entryTime:(new Date).getTime()})});return l},submit:function(){var t=this;setTimeout(function(){var a=Object(l["a"])(t.$refs.hott.hotInstance.getSourceData());t._normalizeWrapper(a);t.$Message.success("保存成功")},100)}}}),p=h,b=(n("56c6"),n("a98d"),n("2877")),y=Object(b["a"])(p,e,o,!1,null,null,null);y.options.__file="caller.vue";a["default"]=y.exports},"534e":function(t,a,n){"use strict";n.d(a,"a",function(){return i}),n.d(a,"b",function(){return c});var e=n("66df"),o=n("2938"),s=o["a"]+"api/ncp/high/",i=function(t){return e["a"].request({url:s+"add",method:"post",data:t})},c=function(t){return e["a"].request({url:s+"list",method:"post",data:t})}},"56c6":function(t,a,n){"use strict";var e=n("df8b"),o=n.n(e);o.a},"767a":function(t,a,n){},9393:function(t,a,n){"use strict";function e(t){if(Array.isArray(t))return t}function o(t,a){var n=[],e=!0,o=!1,s=void 0;try{for(var i,c=t[Symbol.iterator]();!(e=(i=c.next()).done);e=!0)if(n.push(i.value),a&&n.length===a)break}catch(t){o=!0,s=t}finally{try{e||null==c["return"]||c["return"]()}finally{if(o)throw s}}return n}function s(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}function i(t,a){return e(t)||o(t,a)||s()}n.d(a,"a",function(){return i})},"94f9":function(t,a,n){"use strict";n.d(a,"a",function(){return i}),n.d(a,"b",function(){return c});var e=n("66df"),o=n("2938"),s=o["a"]+"api/base/",i=function(t){return e["a"].request({url:s+"add",method:"post",data:t})},c=function(t){return e["a"].request({url:s+"list",method:"post",data:t})}},a98d:function(t,a,n){"use strict";var e=n("767a"),o=n.n(e);o.a},df8b:function(t,a,n){}}]);
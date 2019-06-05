Vue.component('preguntas',{
	template:`
	<div>
		<h2>{{materia.nombre}}</h2>
		<div class="box">
            <label for="preg">Pregunta</label>
            <input type="text" name="preg" size="85" v-model="current_preg" @keyup.enter="fn_add">
            <input type="button" value="+" @click="fn_add" >
        </div>
        <button @click="fn_ver">Enviar al servidor</button>
        <ul v-if="pregs.length>0">
            <li v-for="(preg,index) in pregs">{{preg.desc}} <button @click="fn_remove_question(index)">x</button><br>
                <respuesta-component v-bind:index="index" v-bind:preg="preg"></respuesta-component>
            </li>
        </ul>
	</div>
	
	`
	,
	methods:{
		 fn_add: function () {
             this.pregs.push({desc: this.current_preg,resps:[]});
             this.current_preg=''
         },
         fn_remove_question:function(index)
         {
             console.log(index);
             this.pregs.splice(index,1)
         },
         fn_ver:function(){
             var arr=[];
             for(var i=0;i<this.pregs.length;i++){
                 var index = -1;
                 var resps=[];
                 for(var j=0;j<this.pregs[i].resps.length;j++){
                     resps[j]=fn_clean_prepare(this.pregs[i].resps[j].desc);
                     if( this.pregs[i].resps[j].isTheRightAnswer) index=j;
                 }
                 arr.push(fn_clean_prepare(this.pregs[i].desc) + '¬'+ resps.join('·') + '¬' + index+ '¬'+this.materia.id)
             }
             this.data=arr.join('\n');
             console.log(this.data);
             alert('Esto se mandaría al servidor\n\n'+this.data);
            
            var fd=new FormData();
     		fd.append("data", this.data);
     		axios({
                 method: 'post',
                 url: '/materia/create',
                 responseType: 'json',
                 data: fd
             })
         },
         fn_asignar_preguntas: function(response)
         {
        	 pregs = response;
         }
	},
	data: function(){
		return{
			pregs: [],
			current_preg:''
		}
	},
	props: ['materia'],
	mounted: function(){
		if( typeof materia.id!='undefined')
			{
			var fd=new FormData();
     		fd.append("id_materia", this.materia.id);
			axios({
                method: 'get',
                url: '/materia/verPreguntas',
                responseType: 'json',
                data: fd
            }).then(this.fn_asignar_preguntas).catch(function(error){});
			}
	}
});
Vue.component('respuesta-component',{
    template:`
    <div class="resp_block">
        <div style="padding-left: 8px">
            <label for="resp">Respuesta</label><input type="text" size="40" v-bind:id="fn_name('resp',index,-1)" v-model:value="inputText" @keyup.enter="fn_add_resp">
            <input type="checkbox" v-model="checked">Respuesta correcta
            <input type="button" value="+" @click="fn_add_resp">
        </div>
        <ul v-if="preg.resps.length>0">
            <li v-for="(resp,idx) in preg.resps">
            {{resp.desc}} <input type="radio" v-bind:id="fn_name('_r',index,idx)" v-bind:name="fn_name('_r',index,-1)" v-bind:value="idx" :checked="resp.isTheRightAnswer" @change="fn_radio_change">{{resp.isTheRightAnswer}}
            </li>
        </ul>
    </div>
    `,
    data:function(){
        return {
            inputText:'',
            checked:true,
            picked:false
        }
    },
    methods:{
    	
        fn_add_resp: function () {
            this.preg.resps.push({desc:this.inputText,isTheRightAnswer:this.checked});
            this.checked=false;
            this.inputText=''
        },
        fn_name:function(pre,mid,pos){
            return pre+'_'+mid+(pos>=0?'_'+pos:'')
        },
        fn_radio_change:function(e){
            for(var i=0;i<this.preg.resps.length;i++){
                this.preg.resps[i].isTheRightAnswer= (i== e.target.value)
            }
        },
    },
    mounted: function () {
        document.getElementById("resp_"+this.index).focus();
    },
    props:['index','preg']
});
function fn_clean_prepare(inStr){
    return inStr.replace('¬', ' ').replace('·', '.').replace("\n",'').trim();
}
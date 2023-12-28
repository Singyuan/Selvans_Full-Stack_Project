const appQuery = new Vue({
    el:'#appQuery',

    data:{
            productList: []

    },
    mounted() {
        this.fetchProductList();
    },

    methods:{
        fetchProductList:function (){
            var _this=this;
            axios.get('/products').then((res=>{
                if(res.data.code){
                    _this.productList=res.data.data;
                }
            }));
        }
    }

    })
new Vue({
    el: '#app',
    data: {
        selectedFile: null,
        imageUrl: null,
    },
    methods: {
        onFileChange(event) {
            this.selectedFile = event.target.files[0];
        },
        uploadImage() {
            const formData = new FormData();
            formData.append('pphoto', this.selectedFile);

            axios.post('/upload', formData)
                .then(response => {
                    // 上傳成功
                    console.log(response.data);
                    this.imageUrl = response.data.data;
                    alert('圖片上傳成功');
                })
                .catch(error => {
                    // 上傳失敗
                    console.error(error);
                    alert('圖片上傳失敗');
                });
        }
    }
});

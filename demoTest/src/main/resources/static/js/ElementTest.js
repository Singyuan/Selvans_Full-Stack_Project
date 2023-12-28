
function  handleSuccess(res, file) {
    console.log(this);
    this.product.pphoto = res.data;
}

const appQuery = new Vue({
    el: '#appQuery',
    data() {
        return {
            tableData: [],
            searchForm: {
                pname: "",
                pcategory: "",
                createTime: [],
            },
            //dialog
            product: {
             pphoto: "",
            },
            dialogImageUrl: [],
            dialogFormVisible: false,
            dialogVisible: false,
            productData:[],
            pnameRules: [
                { required: true, message: '產品名稱為必填項', trigger: 'blur' },
                {
                    pattern: /^[\u4e00-\u9fa5a-zA-Z]{0,250}$/,
                    message: '輸入內容不符合要求',
                    trigger: 'blur'
                }
            ],
            pstatusRules: [
                { required: true, message: '產品狀態為必填項', trigger: 'blur' },
                {
                    pattern: /^[01]$/,
                    message: '輸入內容不符合要求',
                    trigger: 'blur'
                }
            ],
            pdescriptionRules: [
                { required: true, message: '產品描述為必填項', trigger: 'blur' },
                {
                    pattern: /^[\u4e00-\u9fa5a-zA-Z]{0,250}$/,
                    message: '輸入內容不符合要求',
                    trigger: 'blur'
                }
            ],
            pnewRules: [
                { required: true, message: '人氣推薦為必填項', trigger: 'blur' },
                {
                    pattern: /^[01]$/,
                    message: '輸入內容不符合要求',
                    trigger: 'blur'
                }
            ],
            hotRules: [
                { required: true, message: '最新商品為必填項', trigger: 'blur' },
                {
                    pattern: /^[01]$/,
                    message: '輸入內容不符合要求',
                    trigger: 'blur'
                }
            ]

        };


    },
    mounted() {
        this.fetchProducts();


    },
    methods: {

        fetchProducts() {
            axios.get("/products").then((result) => {
                this.tableData = result.data.data;
            }).catch(error => {
                console.error(error);
            });
        },
        onSubmit() {
            alert("查詢數據");
        },
        handleSizeChange(val) {
            alert("每頁紀錄數變化" + val);
        },
        handleCurrentChange(val) {
            alert("頁碼發生變化" + val);
        },
        deleteByIds() {
            // 大量刪除的操作
        },
        deleteById(pid) {
        //單筆刪除操作
        axios.delete("/product/"+pid)
            this.$forceUpdate();
            window.location.reload()
        },
        //修改的查詢回顯
        getProductByid(pid) {
            this.dialogFormVisible = true
            axios.get("/product/" + pid).then((result) => {
                this.dialogFormVisible = true;
                this.product = result.data.data;

            }).catch(error => {
                console.error(error);
            });
        },
        updateproduct(){
            this.dialogFormVisible = false
            axios.put("/product/update",this.product)
            window.location.reload()
        },
        addproduct() {
            // 提交新增產品的操作
            axios.post("/products", this.product
            ).then(resp => {
                this.dialogFormVisible = false
                if (resp.data.code === "1") {
                    this.dialogFormVisible = false;
                    this.product = {pphoto: ""};




                } else {
                    this.$message.error(resp.data.msg);
                }
                window.location.reload()
            })
                .catch(error => {
                    // 請求失敗時的處理邏輯
                    console.error(error);
                });
        },

        handlePictureCardPreview(file) {
            圖片預覽功能
            this.dialogImageUrl = file.url || URL.createObjectURL(file.raw);
            this.dialogVisible = true;

        },
        handleRemove(file, filelist) {
            // 移除圖片時的回調函數
            this.pphoto = []; // 清空已上傳的圖片文件
            this.dialogVisible = false; // 隱藏對話框
            this.dialogImageUrl = ''; // 清空圖片URL
        },

        handleUploadSuccess: handleSuccess,
    }
    });
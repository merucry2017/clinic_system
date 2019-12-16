<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="身份证号" prop="idCard">
      <el-input v-model="dataForm.idCard" placeholder="身份证号"></el-input>
    </el-form-item>
    <el-form-item label="真实姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="pwd">
      <el-input v-model="dataForm.pwd" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="tel">
      <el-input v-model="dataForm.tel" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="地址" prop="addr">
      <el-input v-model="dataForm.addr" placeholder="地址"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          idCard: '',
          name: '',
          pwd: '',
          age: '',
          sex: '',
          tel: '',
          addr: ''
        },
        dataRule: {
          idCard: [
            { required: true, message: '身份证号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '真实姓名不能为空', trigger: 'blur' }
          ],
          pwd: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '电话不能为空', trigger: 'blur' }
          ],
          addr: [
            { required: true, message: '地址不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/patient/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.idCard = data.patient.idCard
                this.dataForm.name = data.patient.name
                this.dataForm.pwd = data.patient.pwd
                this.dataForm.age = data.patient.age
                this.dataForm.sex = data.patient.sex
                this.dataForm.tel = data.patient.tel
                this.dataForm.addr = data.patient.addr
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/patient/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'idCard': this.dataForm.idCard,
                'name': this.dataForm.name,
                'pwd': this.dataForm.pwd,
                'age': this.dataForm.age,
                'sex': this.dataForm.sex,
                'tel': this.dataForm.tel,
                'addr': this.dataForm.addr
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>

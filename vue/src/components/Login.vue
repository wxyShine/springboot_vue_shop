<template>
  <div class="login_container">
    <div class="login_box">
      <div class="avatar">
        <img src="../assets/logo.png" alt="logo">
      </div>
        <el-form :model="loginFrom" :rules="rules" ref="loginFormRef" class="login_form" label-width="0px">
          <el-form-item prop="username">
            <el-input prefix-icon="iconfont icon-login_username" v-model="loginFrom.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input show-password="" prefix-icon="iconfont icon-mima "  v-model="loginFrom.password" @keyup.enter="login('loginFormRef')"></el-input>
          </el-form-item>
          <el-form-item class="btns">
          <el-button type="primary" @click="login('loginFormRef')" :loading="isLoding">登录</el-button>
          <el-button type="info" @click="reset('loginFormRef')">重置</el-button>
          </el-form-item>
        </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      loginFrom: {
        username: 'wxy',
        password: 'wxy'
      },
      rules: {
        /* 验证规则 */
        username: [
          { required: true, message: '用户名不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      },
      isLoding: false

    }
  },
  methods: {
    /* 登录 */
    login: function (loginFormRef) {
      this.isLoding = true
      this.$message.closeAll()
      this.$refs[loginFormRef].validate(async valid => {
        /* 验证失败 */
        if (!valid) return false
        const that = this
        /* 验证通过发送登录请求 */
        const res = await this.$axios.post('/login', this.loginFrom).catch( error => {
          this.isLoding = false
          return that.$message.info('接口请求失败!')
        })
        const data = res.data.data
        if (data === null) {
          this.isLoding = false
          this.$message.error('登录失败!')
        } else {
          this.isLoding = false
          this.$message.success('登录成功!')
          window.sessionStorage.setItem('token', data.token)
          this.$router.push('/main')
        }
      })
    },
    /* 重置 */
    reset (loginFormRef) {
      this.$refs[loginFormRef].resetFields()
    }
  }
}
</script>

<style lang="less" scoped>
.login_container{
  background-color: #2b4b6b;
  height: 100%;
}
  .login_box{
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
     .avatar{
      width: 130px;
      height: 130px;
       border: 1px solid #fff;
       border-radius: 50%;
       padding: 10px;
       box-shadow: 0 0 10px #ddd;
       position: absolute;
       left: 50%;
       transform: translate(-50%, -50%);
       background-color: #fff;
      img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eee;
      }
    }
  }
  .btns{
    display: flex;
    justify-content: flex-end;
  }
  .login_form{
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px ;
    box-sizing: border-box;
  }
</style>

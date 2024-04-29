<template>
  <el-form :model="form" label-width="auto" style="max-width: 600px">
    <el-form-item label="name">
      <el-input v-model="form.username"/>
    </el-form-item>
    <el-form-item label="password">
      <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button @click="login">登录</el-button>
      <el-button @click="register">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data(){
    return {
      form:{}
    }
  },
  methods:{
    login(){
      this.$http.post().then(data=>{
        if(data.isSucceed){
          this.$router.push({name:'index'})
        }
      })
    }
  }
}
</script>

<style>


</style>

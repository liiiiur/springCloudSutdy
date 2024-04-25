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

<script lang="ts" setup>
import {reactive} from 'vue'
import request from '../../utils/request.js'
// do not use same name with ref
const form = reactive({
  username: '',
  password: ''
})

const login = () => {
  request.post('http://localhost:8000/common/login', {
    username: form.username,
    password: form.password
  })
}
const register = () => {

}
</script>

const url='http://localhost:8000/'

const urls=class {
    static m(){
        const register=`${url}/register`

        const login=`${url}/login`

        return {
            register,
            login
        }
    }
}

export default urls
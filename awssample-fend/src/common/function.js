import axios from 'axios'
import api from '@/api'

async function healthCheck () {
  try {
    const result = await axios.get(api.healthCheck)
    if(result.status == 200) return true;
    else return false;
  } catch (error) {
    return false
  }
}

const func = {
  healthCheck
}

export default func;
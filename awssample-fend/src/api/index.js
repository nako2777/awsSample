export default {
    healthCheck: import.meta.env.VITE_BACKEND_API + "healthCheck",
    getS3List: import.meta.env.VITE_BACKEND_API + "getS3List",
    getS3File: import.meta.env.VITE_BACKEND_API + "getS3File",
    initRDS: import.meta.env.VITE_BACKEND_API + "initRDS",
}
namespace java org.wuzc.thrift.example

struct UserInfo {
    1: string   userName,
    2: string   userLocation,
    3: i32      age,
}

struct RequestInfo {
    1: i32      age,
}

struct ResultInfo {
    1: i32      code,
    2: UserInfo userInfo,
}
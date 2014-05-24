byte[] buffer = new byte[4]
buffer[0] = 51
buffer[1] = 53
buffer[2] = 51
buffer[3] = 54

long filesize = 0L
buffer.eachByte {
    filesize = filesize * 10L + (long) (new String(it).minus(0) as int)
}

println filesize

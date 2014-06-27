List datastores = [ ["name":"name1"], ["name":"name2"], ["name":"name3"] ]
List names = datastores.collect { it.name }

println names


List keys = ["Host_Addr", "Transmitted", "Recieved", "Duplicated", "Packet_Lost", "Round-trip_Min_MS", "Round-trip_Avg_MS", "Round-trip_Max_MS"]

assert "iPacket_Lost" in keys

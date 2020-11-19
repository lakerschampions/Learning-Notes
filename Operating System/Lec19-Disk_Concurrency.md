# Disk

## Components
- Cylinders（柱面）: a collection of tracks in the same relative position to the spindle
- tracks（磁道）: a concentric circle on a single platter（盘面） side
- sectors（扇区）: segments of a track (usually 512B or 4KB in size). Sectors usually have an equal number of bytes in them, consisting of a reamble, data, and an error correcting code (ECC).

## Access Time
Access time = seek time + rotational delay + transfer time
- Seek time = time needed to move the arm to the cylinder (dominant)
  - The estimated seek time (i.e., to move the arm from one track to another) is: *Ts = n × m + s* 
  - In which *Ts* denotes the estimated seek time, *n* the number of tracks to be crossed, *m* the crossing time per track, and *s* any additional startup delay
- Rotational latency = time before the sector appears under the head (on average half the rotation time)
- Transfer time = time to transfer the data

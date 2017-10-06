package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageEntityEmail#64e475c2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageEntityEmail() : TLAbsMessageEntity() {
    override var offset: Int = 0

    override var length: Int = 0

    private val _constructor: String = "messageEntityEmail#64e475c2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(offset: Int, length: Int) : this() {
        this.offset = offset
        this.length = length
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(offset)
        writeInt(length)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        offset = readInt()
        length = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageEntityEmail) return false
        if (other === this) return true

        return offset == other.offset
                && length == other.length
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x64e475c2.toInt()
    }
}
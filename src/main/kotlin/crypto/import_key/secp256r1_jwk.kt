package crypto.import_key


import id.walt.crypto.keys.KeyType
import id.walt.crypto.keys.LocalKey
import id.walt.crypto.keys.LocalKeyMetadata

suspend fun main() {
    import_secp256r1_jwk()
}
suspend fun import_secp256r1_jwk(){
    println("Importing private JWK...")
    val key = LocalKey.generate(KeyType.secp256r1, LocalKeyMetadata())
    val privateKeyJsonString = key.jwk.toString()
    val privateKeyResult = LocalKey.importJWK(privateKeyJsonString)
    println("Success: "+privateKeyResult.isSuccess)
    println("Getting private key...")
    println("Private key result: "+privateKeyResult.getOrThrow().jwk)


    println("Importing public JWK...")
    val key1 = LocalKey.generate(KeyType.secp256r1, LocalKeyMetadata())
    val publicKeyJsonString = key1.getPublicKey().jwk.toString()
    println(publicKeyJsonString)
    val publicKeyResult = LocalKey.importJWK(publicKeyJsonString)
    println("Success: "+publicKeyResult.isSuccess)
    println("Getting public key...")
    println("Public key result: "+publicKeyResult.getOrThrow().getPublicKey().jwk)

}